package com.damifan.test.pattern.factory;

/**
 * @author wanglei
 * @create 2017/10/26 14:56
 * <p>
 * TODO
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
