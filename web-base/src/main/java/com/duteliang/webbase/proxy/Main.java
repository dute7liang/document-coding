package com.duteliang.webbase.proxy;

/**
 * @author: zl
 * @Date: 2019-12-14 15:20
 */
public class Main {
    public static void main(String[] args) throws Exception {
        // 静态代理
//        IComputerStore computerStore = new ComputerStore();
//        IComputerStore computerStoreStaticProxy = new ComputerStoreStaticProxy(computerStore);
//        computerStoreStaticProxy.buyComputer();
        // JDK代理
        // 打开保存JDK动态代理生成的类文件
//        IComputerStore computerStore = new ComputerStore();
//        IComputerStore proxy = (IComputerStore)Proxy.newProxyInstance(ComputerStore.class.getClassLoader(),
//                ComputerStore.class.getInterfaces(), new JdkProxyHandler(computerStore));
//        proxy.buyComputer();
        // cdlib代理
        CglibProxyHandle cglibProxyHandle = new CglibProxyHandle();
        IComputerStore instance = (IComputerStore)cglibProxyHandle.getInstance(new ComputerStore());
        instance.buyComputer();
    }

}
