package april.day08;

//조류 Bird
//- 날수있는지 여부  canFly
//- 생성자(이름,나이, canFly)
//- printCanFly()   --  날수있는지 여부에 따라서..
// 이름+날수있습니니다. or 이름+날 수 없습니다.
//-makeSound()   ( 오버라이딩!!)
public class Bird extends Animal{
    private boolean conFly;
    public Bird(String name, int age, boolean canFly){
        super(name,age);
//        this()  나의 생성자.
//        super() 부모의 생성자.  생락하면 무조건 부모의 디폴트생성자를 호출!!
        this.conFly = canFly;
    }

    public void printCanFly(){
        if(conFly)
            System.out.println(name + "은 날 수 있습니다.");
        else
            System.out.println(name+ "은 날 수 없습니다. ");
    }

    @Override
    public void makeSound() {
        System.out.println(name + "이 소리를 냅니다.");
    }
}
