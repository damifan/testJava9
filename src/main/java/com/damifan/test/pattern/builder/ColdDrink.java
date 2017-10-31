package com.damifan.test.pattern.builder;

/**
 * @author wanglei
 * @create 2017/10/31 10:43
 * <p>
 * TODO
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
