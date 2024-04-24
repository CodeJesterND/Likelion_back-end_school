package april.day08.animal;

public class ZooTest {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.addAnimal(new Lion("아기사자",10));
        zoo.addAnimal(new Lion("엄마사자",20));
        zoo.addAnimal(new Elephant("코끼리", 200));
        zoo.addAnimal(new Elephant("코끼리", 200));
        zoo.addAnimal(new Elephant("코끼리", 200));
        zoo.addAnimal(new Elephant("코끼리", 200));


        zoo.makeAllSounds();
    }
}
