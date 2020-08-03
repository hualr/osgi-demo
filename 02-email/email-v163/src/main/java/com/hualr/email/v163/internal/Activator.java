package com.hualr.email.v163.internal;

import com.hualr.email.api.IEmailService;
import com.hualr.email.v163.EmailService163;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.Dictionary;
import java.util.Hashtable;


public class Activator implements BundleActivator {
    private ServiceRegistration<IEmailService> serviceRegistration;
    @Override
    public void start(BundleContext context) throws Exception {
        Dictionary<String,Object> properties=new Hashtable<>();
        properties.put("vendor","163");
        serviceRegistration=context.registerService(IEmailService.class,new EmailService163(),properties);
        System.out.println("完成163的注册");

    }


    @Override
    public void stop(BundleContext context) throws Exception {
        serviceRegistration.unregister();
    }
}
