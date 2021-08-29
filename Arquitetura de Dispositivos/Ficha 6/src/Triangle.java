public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(){
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public Triangle(Point a,Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point getPointA() {
        return a;
    }

    public Point getPointB() {
        return b;
    }

    public Point getPointC() {
        return c;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public void setC(Point c) {
        this.c = c;
    }

    public void setAll(Point a,Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getBase() {
        return a.getDistance(b);
    }

    public double getHeight() {
        return a.getDistance(c);
    }

    public double getArea() {
        return (getBase() * getHeight()) / 2;
    }
}
