package april.day15;

public class Bird extends Animal{
    public Bird(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("짹짹");
    }
}
