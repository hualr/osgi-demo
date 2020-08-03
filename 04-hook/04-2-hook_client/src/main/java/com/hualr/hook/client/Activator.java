package com.hualr.hook.client;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import java.util.Collection;

public class Activator implements BundleActivator
{

    public void start(BundleContext bundleContext) throws Exception
    {
        invoke(bundleContext, "APP");
        invoke(bundleContext, "PC");
    }

    public void stop(BundleContext bundleContext) throws Exception
    {

    }

    private void invoke(BundleContext bundleContext, String from)throws Exception
    {
        //这里可以理解为键值对 因为服务是from,name格式的property
        String filter = "(from="+from+")";
        Collection<ServiceReference<Runnable>> list = bundleContext.getServiceReferences(Runnable.class, filter);
        //服务钩子在查找的动作中直接将该服务移除,从而使得我们无法直接查找
        System.out.println("符合的服务有"+ from + " size: " + list.size());
    }
}
