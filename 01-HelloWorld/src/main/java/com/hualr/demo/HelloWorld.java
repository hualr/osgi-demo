package com.hualr.demo;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**这是第一个bundle
 * 主要强调几点
 * 一. 代码层面
 * 我们基本上服务想要在osgi容器中运行就得以BundleActivator的方式运行着.因此我们必须引入他
 * 这里的start stop是必须的
 *
 * 二. pom层面
 * 最外面的pom我们不需要理会,因为没有什么意义
 * 之后的所有新创建的bundle都会以moudule的形式存在着
 * */
public class HelloWorld implements BundleActivator {

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("hello OSGI--start.....");
        //要想使用这个服务,首先得得再01 import中导出这个类
       // new User().speak();
    }


    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("hello OSGI---stop.......");
    }
}