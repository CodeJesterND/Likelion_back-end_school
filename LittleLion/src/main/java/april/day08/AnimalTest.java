package april.day08;

public class AnimalTest {
    public static void main(String[] args) {
        Animal animal ;
        if(args[0].equals("조류")){
            animal = new Bird("참새",3,true);
        }else{
            animal = new Mammal("고양이",2,"우리집");
        }

        animal.makeSound();
        animal.printInfo();

        if(animal instanceof Bird) {
            ((Bird) animal).printCanFly();
        }else{
            ((Mammal)animal).printHabitat();
        }
    }
}
