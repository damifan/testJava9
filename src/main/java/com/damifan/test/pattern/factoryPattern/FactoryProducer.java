package com.damifan.test.pattern.factoryPattern;

/**
 * @author wanglei
 * @create 2017/10/26 16:34
 * <p>
 * TODO
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        }
        return null;
    }
}
