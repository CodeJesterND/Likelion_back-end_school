package april.day08;

public class StudentTest {
    public static void main(String[] args) {
        학생 student = new 학생("정다예","12345",20);

        student.printStudentInfo();

        student.공부하다();   //정다예는 공부중!!

        student.공부하다("java"); //정다예는 java 공부중!!

        student.공부하다("css");

    }
}
