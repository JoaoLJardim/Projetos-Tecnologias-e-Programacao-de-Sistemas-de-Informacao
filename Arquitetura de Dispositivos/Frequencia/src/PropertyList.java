import java.util.ArrayList;

public class PropertyList {

    private ArrayList<Property> properties;


    public PropertyList () {
        this.properties = new ArrayList<Property>();
    }

    public PropertyList (ArrayList<Property> properties) {
        this.properties = properties;
    }


    public ArrayList<Property> getProperties() {
        return properties;
    }

    public void sort () {
        this.properties.sort(new Compare());
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }

    public void addProperties(Property property) {
        properties.add(property);
    }

    @Override
    public String toString() {
        return "PropertyList{" +
                "properties=" + properties +
                '}';
    }
}
