package com.damifan.test.pattern.decorator;

import com.damifan.test.pattern.factory.Shape;

/**
 * @author wanglei
 * @create 2017/11/1 14:24
 * <p>
 * TODO
 */
public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        shape.draw();
        setRedBorder(shape);
    }

    private void setRedBorder(Shape decoratedShape) {
        System.out.println("Border Color: Red");
    }
}
