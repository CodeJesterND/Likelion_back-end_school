package april.day08.animal;

public class Lion extends Animal{
    private int maneSize;
    public Lion(String name, int maneSize){
        super(name);
        this.maneSize = maneSize;
    }

    @Override
    public void makeSound() {
        System.out.println(name+"이 으르렁 거립니다.");
    }
}
