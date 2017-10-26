package com.damifan.test.pattern.factoryPattern;

/**
 * @author wanglei
 * @create 2017/10/26 16:27
 * <p>
 * TODO
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
