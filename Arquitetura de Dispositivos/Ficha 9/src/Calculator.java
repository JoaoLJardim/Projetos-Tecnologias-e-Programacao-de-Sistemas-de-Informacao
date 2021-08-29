public class Calculator {

    private double value;

    public Calculator() {
        value = 0.0;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double newValue) {
        this.value = newValue;
    }

    public void clear() {
        value = 0.0;
    }

    public void add(double term){
        value += term;
    }
}
