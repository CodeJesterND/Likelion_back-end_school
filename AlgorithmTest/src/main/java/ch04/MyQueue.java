package ch04;

public class MyQueue {
    private int maxSize; // 큐의 최대 크기
    private int[] queueArray; // 큐를 저장하는 배열
    private int front; // 큐의 맨 앞을 가리키는 포인터
    private int rear; // 큐의 맨 뒤를 가리키는 포인터
    private int currentSize; // 현재 큐에 저장된 요소의 개수

    // 생성자: 큐의 최대 크기를 인자로 받아 초기화
    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }

    // 큐에 데이터를 추가하는 메소드
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("큐가 가득 찼습니다.");
            return;
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = data;
        currentSize++;
    }

    // 큐에서 데이터를 제거하고 반환하는 메소드
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("큐가 비어있습니다.");
            return -1; // 임의의 값으로 처리
        }
        int data = queueArray[front];
        front = (front + 1) % maxSize;
        currentSize--;
        return data;
    }

    // 큐의 맨 앞에 있는 데이터를 반환하는 메소드
    public int peek() {
        if (isEmpty()) {
            System.out.println("큐가 비어있습니다.");
            return -1; // 임의의 값으로 처리
        }
        return queueArray[front];
    }

    // 큐가 비어있는지 확인하는 메소드
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    // 큐가 가득 찼는지 확인하는 메소드
    public boolean isFull() {
        return (currentSize == maxSize);
    }

    // 큐의 내용을 출력하는 메소드(디버깅용)
    public void display() {
        System.out.print("큐 내용: ");
        int count = 0;
        int index = front;
        while (count < currentSize) {
            System.out.print(queueArray[index] + " ");
            index = (index + 1) % maxSize;
            count++;
        }
        System.out.println();
    }

    // 테스트를 위한 메인 메소드
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(5); // 최대 크기가 5인 큐 생성

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        queue.display(); // 큐 내용 출력: 1 2 3 4

        System.out.println("가장 앞에 있는 데이터: " + queue.peek()); // 출력: 1

        queue.dequeue(); // 큐에서 데이터 제거
        queue.dequeue(); // 큐에서 데이터 제거

        queue.display(); // 큐 내용 출력: 3 4
    }
}