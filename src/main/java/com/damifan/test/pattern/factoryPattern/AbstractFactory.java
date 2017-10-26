package com.damifan.test.pattern.factoryPattern;

/**
 * @author wanglei
 * @create 2017/10/26 16:29
 * <p>
 * TODO
 */
public abstract class AbstractFactory {

    abstract Shape getShape(String shape);

    abstract Color getColor(String color);

}
