package com.hualr.email.v126.internal;

import com.hualr.email.api.IEmailService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.Dictionary;
import java.util.Hashtable;

public class Activator implements BundleActivator {

    private ServiceRegistration<?>  serviceRegistration;
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        Dictionary<String,Object> properties=new Hashtable<>();
        properties.put("vendor","126");
        serviceRegistration= bundleContext.registerService(IEmailService.class.getName(),new Email162Factory(),properties);
        System.out.println("完成126的注册");

    }

    @Override
    public void stop(BundleContext context) throws Exception {

    }
}
