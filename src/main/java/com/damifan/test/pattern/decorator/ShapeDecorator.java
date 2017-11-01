package com.damifan.test.pattern.decorator;

import com.damifan.test.pattern.factory.Shape;

/**
 * @author wanglei
 * @create 2017/11/1 14:21
 * <p>
 * TODO
 */
public abstract class ShapeDecorator implements Shape {

    protected Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        shape.draw();
    }
}
