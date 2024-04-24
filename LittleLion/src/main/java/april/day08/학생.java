package april.day08;

public class 학생 {
    //속성
    //접근제한자 타입 속성명;
    private String name;
    private int 나이;
    private String 학번;

    public 학생(String name, String 학번, int 나이){
        this.name = name;
        this.학번 = 학번;
        this.나이 = 나이;
    }
    //getter, setter
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public int get나이(){
        return 나이;
    }

    public void set나이(int 나이) {
        this.나이 = 나이;
    }

    public String get학번() {
        return 학번;
    }

    public void set학번(String 학번) {
        this.학번 = 학번;
    }

    public void printStudentInfo(){
        System.out.println("학생 이름:"+name);
        System.out.println("학생 학번:"+학번);
        System.out.println("학생 나이:"+나이);
    }

    public void 공부하다(){
        System.out.println(name+"은 공부중!!");
    }
    public void 공부하다(String subject){
        System.out.println(name+"은"+subject+" 공부중!!");
    }
}
