package com.hualr.email.client;

import com.hualr.email.api.IEmailService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        ServiceReference<?>[]references=bundleContext.getAllServiceReferences(IEmailService.class.getName(),null);
        if (references!=null){
            for (ServiceReference<?> reference:references){
                IEmailService emailService= (IEmailService) bundleContext.getService(reference);
                emailService.sendEmail("hello OSGI");

                System.out.println("获取126服务");
                getService(bundleContext,"126");


            }
        }

    }

    private void getService(BundleContext bundleContext, String vendor) throws InvalidSyntaxException {
        String filter="(vendor="+vendor+")";
        ServiceReference<?> [] list=bundleContext.getServiceReferences(IEmailService.class.getName(),filter);
        if (list!=null){
            for (ServiceReference<?> reference:list){
                IEmailService emailService= (IEmailService) bundleContext.getService(reference);
                System.out.println(emailService);
                emailService.sendEmail("   hello is me");
            }
        }

    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

    }
}
