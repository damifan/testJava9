package com.damifan.test.pattern.builder;

/**
 * @author wanglei
 * @create 2017/10/31 10:46
 * <p>
 * TODO
 */
public class Pepsi extends ColdDrink {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}
