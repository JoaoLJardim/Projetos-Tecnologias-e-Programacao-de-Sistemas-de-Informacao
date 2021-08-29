public class Rectangle {

    private Point topLeftPoint;
    private double height;
    private double width;

    public Rectangle() {
        this.topLeftPoint = null;
        this.height = 0.0;
        this.width = 0.0;
    }

    public Rectangle(Point topLeftPoint, double height, double width) {
        this.topLeftPoint = topLeftPoint;
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public Point getTopLeftPoint() {
        return topLeftPoint;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setTopLeftPoint(Point topLeftPoint) {
        this.topLeftPoint = topLeftPoint;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setAll(double width, double height, Point topLeftPoint) {
        this.width = width;
        this.height = height;
        this.topLeftPoint = topLeftPoint;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return Math.pow(width + height, 2);
    }

    public boolean contains(Point point) {
        Point b = new Point(topLeftPoint.getX(), topLeftPoint.getY() + height);
        Point c = new Point(b.getX() + width, b.getY());
        Point d = new Point(c.getX(), topLeftPoint.getY());
        return !(point.getX() < topLeftPoint.getX()) && !(point.getX() > d.getX()) && !(point.getY() > b.getY()) && !(point.getY() < topLeftPoint.getY());
    }
}
