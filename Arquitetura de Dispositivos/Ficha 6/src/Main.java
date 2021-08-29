public class Main {
    public static void main(String[] args) {
        Point a= new Point(0,0);
        Rectangle rectangle = new Rectangle(a,2,2);
        Point b= new Point(2,3);
        System.out.println(rectangle.contains(b));
    }
}
