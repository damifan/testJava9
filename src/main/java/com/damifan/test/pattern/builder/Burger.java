package com.damifan.test.pattern.builder;

/**
 * @author wanglei
 * @create 2017/10/31 10:42
 * <p>
 * TODO
 */
public abstract class Burger implements Item {
    @Override
    public String name() {
        return null;
    }

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
