package april.day15;

public class AnimalDemo {
    public static void main(String[] args) {
        Animal bird = new Bird("봄봄");
        bird.makeSound();

        Animal cat = new Cat("연지");
        cat.makeSound();
    }
}
