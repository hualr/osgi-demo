package com.hualr.listener;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

public class EmailService implements BundleActivator {

    private ServiceRegistration<Runnable> serviceRegistration;

    public void start(BundleContext bundleContext) throws Exception {

        Dictionary<String, Object> properties = new Hashtable<>();
        properties.put("service.type", "email");

        serviceRegistration = bundleContext.registerService(Runnable.class,
                () -> {
                            System.out.println("service-email");
                      }, properties);

        //注册完服务之后尝试修改属性
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Dictionary<String, Object> properties2 = new Hashtable<>();
            //这里修改了服务的属性,这意味着此时我们不会在监听不匹配类型的属性
            properties2.put("service.type", "sms");
            serviceRegistration.setProperties(properties2);
        }).start();
    }

    public void stop(BundleContext bundleContext) throws Exception {
        serviceRegistration.unregister();
    }
}