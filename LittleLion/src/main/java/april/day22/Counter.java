package april.day22;

class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class CounterUpdater extends Thread {
    private Counter counter;
    private int increments;

    public CounterUpdater(Counter counter, int increments) {
        this.counter = counter;
        this.increments = increments;
    }

    @Override
    public void run() {
        for (int i = 0; i < increments; i++) {
            counter.increment();
            System.out.println("스레드 " + Thread.currentThread().getId() + "의 카운터 값: " + counter.getCount());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class CounterMain {
    public static void main(String[] args) {
        final int THREADS = 5;
        final int REPEAT_COUNT = 1000;

        Counter counter = new Counter();

        CounterUpdater[] threads = new CounterUpdater[THREADS];

        for (int i = 0; i < THREADS; i++) {
            threads[i] = new CounterUpdater(counter, REPEAT_COUNT);
            threads[i].start();
        }

        for (CounterUpdater thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("최종 카운터 값: " + counter.getCount());
    }
}