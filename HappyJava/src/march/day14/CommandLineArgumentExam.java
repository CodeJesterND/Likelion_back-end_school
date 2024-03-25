package march.day14;

public class CommandLineArgumentExam {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("사용법 : CommandLineArgumentExam 값 값 ....");
            System.exit(0); // return; 으로 변겯 가능
        }

        for (String arg : args) {
            System.out.println(arg);
        }
    }
}