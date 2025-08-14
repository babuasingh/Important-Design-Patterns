/*
When to use the Factory Pattern
    When object creation logic is complex or involves decision-making.
    When you want to create objects without exposing the actual class.
    When you need loose coupling between client code and actual implementations.
*/

interface Shape{
    void draw();
}

class circle implements Shape{
    public void draw() {
        System.out.println("Drawing Circle.......");
    }
}

class Square implements Shape{
    public void draw() {
        System.out.println("Drawing Square.......");
    }
}

class ShapeFactory{
    public static Shape getShape(String type){
        if(type.equalsIgnoreCase("circle")){
            return new circle();
        }else if(type.equalsIgnoreCase("Square")){
            return new Square();
        }
        else return null;
    }
}

public class FactoryDesign {
    public static void main(String[] args) {
        Shape circle=ShapeFactory.getShape("circle");
        circle.draw();
        Shape square=ShapeFactory.getShape("square");
        square.draw();
    }
}
