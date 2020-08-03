package com.hualr.listener;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

public class ListenerActivator implements BundleActivator {


    public void start(BundleContext bundleContext) throws Exception {
        /**
         * 监听所有服务事件
         */
//		bundleContext.addServiceListener(new ServiceListener(){
//			public void serviceChanged(ServiceEvent event) {
//				System.out.println(event.getSource() + "\t" + event.getType());
//			}
//		});

        /**
         * 监听指定属性的服务事件 只是监听服务类型为email 没有匹配另外一个notify的服务类型
         */
        String filter = "(service.type=email)";
        bundleContext.addServiceListener(new ServiceListener(){
            public void serviceChanged(ServiceEvent event) {
                System.out.println("event.getSource() 为:"+event.getSource() + ";event.getType()为:" + event.getType());
            }
        }, filter);
    }

    public void stop(BundleContext context) throws Exception {

    }
}
