package com.hualr.hook;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.hooks.service.FindHook;

import java.util.Collection;

public class Activator implements BundleActivator
{
    private ServiceRegistration<FindHook> serviceRegistration;

    public void start(BundleContext bundleContext) throws Exception
    {
        // 注册钩子
        serviceRegistration = bundleContext.registerService(FindHook.class, new MyFindHook(), null);
    }

    public void stop(BundleContext bundleContext) throws Exception
    {
        serviceRegistration.unregister();
    }
}

//确认找到钩子之后的行为动作  我们目前的情况是找到后对这个服务做一系列操作 然后将这个服务屏蔽
class MyFindHook implements FindHook
{
    //这个钩子是用的最多的 另外的钩子没有使用的价值所以我就不写了
    public void find(BundleContext context, String name, String filter, boolean allServices,
                     Collection<ServiceReference<?>> references)
    {
        System.out.println("service hook is invoke ");
        System.out.println("serivce name:"+name+"/t filter:"+filter+"/t allServices:"+allServices);
        //找到APP之后就将该服务移除.目的是防止这个服务被调用到
        for(ServiceReference<?> sf : references)
        {
            if("APP".equals(sf.getProperty("from")))
            {
                references.remove(sf);
            }
        }
    }
}

