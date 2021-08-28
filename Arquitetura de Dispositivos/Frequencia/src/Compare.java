import java.util.Comparator;

public class Compare implements Comparator<Property> {


    @Override
    public int compare(Property o1, Property o2) {
        return o1.getPrice() * o2.getPrice() - o1.getPrice() * o1.getPrice();
    }
}
