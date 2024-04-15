package april.day15.box;

public class GenericInheritanceExample {
    public static void main(String[] args) {
        SpecialBox<String> specialBox = new SpecialBox<>("Hello World");
        specialBox.printContect(); // 출력: Special box contains: Hello World

        ColoredBox<String, String> coloredBox = new ColoredBox<>("Hello World", "Red");
        System.out.println(coloredBox); // 출력: Colored box with color Red containing: Hello World
    }
}