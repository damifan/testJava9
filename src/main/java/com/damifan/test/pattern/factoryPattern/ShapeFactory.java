package com.damifan.test.pattern.factoryPattern;

/**
 * @author wanglei
 * @create 2017/10/26 14:58
 * <p>
 * TODO
 */
public class ShapeFactory {

    public Shape getShape(String shape) {

        switch (shape.toLowerCase()) {
            case "rectangle":
                return new Rectangle();
            case "circle":
                return new Circle();
            case "square":
                return new Square();
            default:
                return null;
        }
    }
}
