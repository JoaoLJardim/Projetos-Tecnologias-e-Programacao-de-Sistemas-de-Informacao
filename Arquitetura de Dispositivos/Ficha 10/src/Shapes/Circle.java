package Shapes;

public class Circle extends Shape {
    private double radius;

    public Circle() { }

    @Override
    public Point getPosition() {
        return super.position;
    }

    public Circle(Point point, double radius) {
        this.position = point;
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius,2);
    }

    @Override
    public double getPerimeter() {
        return Math.PI * (radius + radius);
    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
