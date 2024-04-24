package april.day08;

public class Animal {
     protected String name;

//    public String getName() {
//        return name;
//    }
//
//    public int getAge() {
//        return age;
//    }

    private int age;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void makeSound(){
        System.out.println(name + "이(가) 소리를 낸다.");
    }
    public void printInfo(){
        System.out.println("이름 : "+ name +", 나이 : "+age);

    }
}


