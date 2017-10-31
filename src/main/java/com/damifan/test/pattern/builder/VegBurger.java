package com.damifan.test.pattern.builder;

/**
 * @author wanglei
 * @create 2017/10/31 10:44
 * <p>
 * TODO
 */
public class VegBurger extends Burger {
    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
