import Shapes.*;

public class Main {
    public static void main(String[] args) {
        Figure figure = new Figure();
        Shape circle = new Circle(new Point(0, 0), 5);
        figure.add(circle);
        Shape rectangle = new Rectangle(new Point(0, 0), 5, 5);
        figure.add(rectangle);
        Shape triangle = new Triangle(new Point(0, 0), new Point(5, 0), new Point(0, 5));
        figure.add(triangle);


        for (Shape shape : figure.getShapes()) {
            System.out.println("Area: " + shape.getArea());
            System.out.println("Perimeter: " + shape.getPerimeter());
        }
    }
}
