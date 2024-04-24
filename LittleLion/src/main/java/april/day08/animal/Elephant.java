package april.day08.animal;

public class Elephant extends Animal {
    private  int trunkLength;

    public Elephant(String name, int trunkLength){
        super(name);
        this.trunkLength = trunkLength;
    }

    @Override
    public void makeSound() {
        System.out.println(name+"가 뿌~~우 합니다.");
    }
}
