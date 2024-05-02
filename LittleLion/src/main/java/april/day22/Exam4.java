package com.exam.day06;
class CounterRunnable implements Runnable {
    private final SynchronizedCounter counter;
    private final int maxCount;

    public CounterRunnable(SynchronizedCounter counter, int maxCount) {
        this.counter = counter;
        this.maxCount = maxCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < maxCount; i++) {
            counter.increment();
        }
    }
}
class SynchronizedCounter {
    private int count = 0; // 공유 자원

    // synchronized 메소드를 사용하여 스레드 간 동기화
    public /*synchronized*/ void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
public class Exam4 {
    public static void main(String[] args) {
        SynchronizedCounter counter = new SynchronizedCounter();
        int maxCount = 1000;

        // Runnable 인스턴스 생성
        Runnable task1 = new CounterRunnable(counter, 2000);
        Runnable task2 = new CounterRunnable(counter, 3000);

        // 스레드 생성 및 시작
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        try {
            // 모든 스레드가 완료될 때까지 대기
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 최종 결과 출력
        System.out.println("최종 카운트: " + counter.getCount());
    }
}
