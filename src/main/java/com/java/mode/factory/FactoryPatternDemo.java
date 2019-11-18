package com.java.mode.factory;

/**
 * @author Gary
 * @since 2019/11/18 16:28
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();
        Shape shape3 = shapeFactory.getShape("RECTANGLE");
        shape3.draw();
        /*使用getClass获取*/
        Shape shapeByGetClass = (Shape) ShapeFactory.getClass(Circle.class);
        shapeByGetClass.draw();

        Rectangle shape = ShapeFactory.getShape(Rectangle.class);
        shape.draw();

        Shape shape4 = (Shape)ShapeFactory.getObject(Square.class);
        shape4.draw();

        Rectangle obj = shapeFactory.getObj(Rectangle.class);
        obj.draw();
        Rectangle obj1 = shapeFactory.getObj(Rectangle.class);
        obj1.draw();

        Shape shape5 = ShapeFactory.getShape(ShapeType.SQUARE);
        shape5.draw();
    }
}
