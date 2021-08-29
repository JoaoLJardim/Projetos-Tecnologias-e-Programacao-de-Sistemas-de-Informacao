package Shapes;

public abstract class Shape {

    protected Point position;

    public Shape() { }

    public Shape(Point point) {
        this.position = point;
    }

    public void setPoint(Point point) {
        this.position = point;
    }

    public abstract Point getPosition();

    public abstract double getArea();

    public abstract double getPerimeter();
}
