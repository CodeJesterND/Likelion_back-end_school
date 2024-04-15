package april.day15;

public class Calculator<T extends Number> {
    private T number;

    public Calculator(T number) {
        this.number = number;
    }

    public double square() {
        return number.doubleValue() * number.doubleValue();
    }

    public static void main(String[] args) {
        Calculator<Integer> integerCalculator = new Calculator<>(5);
        Calculator<Double> doubleCalculator = new Calculator<>(5.5);

        System.out.println("Integer square: " + integerCalculator.square());
        System.out.println("Double square: " + doubleCalculator.square());
    }
}