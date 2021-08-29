import java.util.Objects;

public class Rational implements Comparable<Rational> {
    private int numerator, denominador;

    public Rational () {

    }

    public Rational(int numerator, int denominador) {
        this.numerator = numerator;
        this.denominador = denominador;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Rational object = (Rational) obj;
        return denominador == object.denominador && numerator == object.numerator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominador);
    }

    @Override
    public int compareTo(Rational o) {
        return getNumerator() * o.getDenominador()
                - o.getNumerator() * getDenominador();
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominador() {
        return this.denominador;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    @Override
    public String toString() {
        return "Rational{" +
                "numerator=" + numerator +
                ", denominador=" + denominador +
                '}';
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }
}
