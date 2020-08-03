package com.hualr.listener;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.Dictionary;
import java.util.Hashtable;

public class NotifyService implements BundleActivator {
    private ServiceRegistration<Runnable> serviceRegistration;

    public void start(BundleContext bundleContext) throws Exception {

        Dictionary<String, Object> properties = new Hashtable<>();
        //这是另外一个服务,注册了但是监听不到 因为类型没有匹配上
        properties.put("service.type", "notify");
        serviceRegistration = bundleContext.registerService(Runnable.class, () -> {}, properties);
    }

    public void stop(BundleContext bundleContext) throws Exception {
        serviceRegistration.unregister();
    }
}