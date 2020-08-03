package com.hualr.email.v126.internal;

import com.hualr.email.api.IEmailService;
import com.hualr.email.v126.Email162;
import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

public class Email162Factory implements ServiceFactory<IEmailService> {

    @Override
    public IEmailService getService(Bundle bundle, ServiceRegistration<IEmailService> registration) {
        System.out.println("bundle:"+bundle.getSymbolicName());
        return new Email162();
    }


    @Override
    public void ungetService(Bundle bundle, ServiceRegistration<IEmailService> registration, IEmailService service) {

    }
}
