package com.duteliang.webbase.proxy;

/**
 * @author: zl
 * @Date: 2019-12-14 15:16
 */
public class ComputerStoreStaticProxy implements IComputerStore{

    private IComputerStore computerStore;

    public ComputerStoreStaticProxy(IComputerStore computerStore) {
        this.computerStore = computerStore;
    }

    @Override
    public String buyComputer() {
        System.out.println("收钱");
        String computer = computerStore.buyComputer();
        System.out.println("拿到电脑");
        System.out.println("发货");
        return computer;
    }
}
