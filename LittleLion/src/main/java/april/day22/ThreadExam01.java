package april.day22;

public class ThreadExam01 {
    public static void main(String[] args) {
        System.out.println("main 시작!!");
        MyThread myThread = new MyThread();
        myThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("main 끝!!");
    }
}
//1. Thread를 상속!!
class MyThread extends Thread{
    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("스레드에서 실제 하고자 하는 일 구현!!! ");
    }
}