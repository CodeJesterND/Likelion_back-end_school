package april.day15.container;

public class ContainerMain {
    public static void main(String[] args) {
        Container<String> stringContainer = new StringContainer();
        stringContainer.set("Hello, Generics");
        System.out.println("String Container: " + stringContainer.get());

        Container<Integer> integerContainer = new IntegerContainer();
        integerContainer.set(10);
        System.out.println("Integer Container: " + integerContainer.get());
    }
}