package april.day08;
//포유류   Mammal
// - 서식지 (속성)
//- 생성자(이름,나이,서식지)
// -makeSound (오버라이딩!!)
// -printHabitat()  - 서식지를 출력하는 메서드.

public class Mammal extends Animal{
    private String habitat;

    public Mammal(String name, int age, String habitat){
        super(name,age);
        this.habitat = habitat;
    }

    @Override
    public void makeSound() {
        System.out.println(name + "가(이) 우는 소리를 냅니다.");
    }

    public void printHabitat(){
        System.out.println(name + "의 서식지는 "+habitat);
    }
}
