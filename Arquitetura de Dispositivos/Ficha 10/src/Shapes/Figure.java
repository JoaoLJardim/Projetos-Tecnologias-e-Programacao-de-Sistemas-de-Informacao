package Shapes;

import java.util.ArrayList;

public class Figure {
    private ArrayList<Shape> shapes;


    public Figure() {
        this.shapes = new ArrayList<>();
    }

    public Figure(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public void add(Shape shape) {
        this.shapes.add(shape);
    }

    public void remove(Shape shape) {
        this.shapes.remove(shape);
    }

    public Shape elementAt(int i) {
        return this.shapes.get(i);
    }
}
