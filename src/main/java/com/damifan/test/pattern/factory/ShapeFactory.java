package com.damifan.test.pattern.factory;

import java.lang.reflect.InvocationTargetException;

/**
 * @author wanglei
 * @create 2017/10/26 14:58
 * <p>
 * TODO
 */
public class ShapeFactory extends AbstractFactory {

    @Override
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

    @Override
    Color getColor(String color) {
        return null;
    }

    public static Object getClass(Class<? extends Shape> cla) {
        Object obj = null;
        try {
            obj = Class.forName(cla.getName()).getConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
