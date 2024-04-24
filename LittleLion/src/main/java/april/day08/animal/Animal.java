package april.day08.animal;

public class Animal {
    protected String name;
    public Animal(String name){
        this.name = name;
    }

    public void makeSound(){
        System.out.println("동물이 소리를 냅니다.");
    }
}
