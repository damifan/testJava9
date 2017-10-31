package com.damifan.test.pattern.builder;

/**
 * @author wanglei
 * @create 2017/10/31 10:45
 * <p>
 * TODO
 */
public class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}