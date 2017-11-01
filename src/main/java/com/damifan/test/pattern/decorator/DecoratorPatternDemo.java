package com.damifan.test.pattern.decorator;

import com.damifan.test.pattern.factory.Circle;
import com.damifan.test.pattern.factory.Rectangle;
import com.damifan.test.pattern.factory.Shape;

/**
 * @author wanglei
 * @create 2017/11/1 14:25
 * <p>
 * TODO
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {

        Shape circle = new Circle();

        Shape redCircle = new RedShapeDecorator(new Circle());

        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
