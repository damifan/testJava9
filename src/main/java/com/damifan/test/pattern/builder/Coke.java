package com.damifan.test.pattern.builder;

/**
 * @author wanglei
 * @create 2017/10/31 10:45
 * <p>
 * TODO
 */
public class Coke extends ColdDrink {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}
