package com.damifan.test.pattern.factory;

/**
 * @author wanglei
 * @create 2017/10/26 16:27
 * <p>
 * TODO
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
