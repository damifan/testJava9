package com.damifan.test.pattern.factoryPattern;

/**
 * @author wanglei
 * @create 2017/10/26 14:56
 * <p>
 * TODO
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
