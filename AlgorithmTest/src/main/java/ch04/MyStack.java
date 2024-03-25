package ch04;

public class MyStack {
    private int maxSize; // 스택의 최대 크기
    private int[] stackArray; // 스택을 저장하는 배열
    private int top; // 스택의 가장 위를 가리키는 포인터

    // 생성자: 스택의 최대 크기를 인자로 받아 초기화
    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new int[maxSize];
        this.top = -1; // 스택이 비어있음을 나타내는 초기값
    }

    // 스택에 데이터를 추가하는 메소드
    public void push(int data) {
        if (isFull()) {
            System.out.println("스택이 가득 찼습니다.");
            return;
        }
        stackArray[++top] = data;
    }

    // 스택에서 데이터를 제거하고 반환하는 메소드
    public int pop() {
        if (isEmpty()) {
            System.out.println("스택이 비어있습니다.");
            return -1; // 임의의 값으로 처리
        }
        return stackArray[top--];
    }

    // 스택이 비어있는지 확인하는 메소드
    public boolean isEmpty() {
        return (top == -1);
    }

    // 스택이 가득 찼는지 확인하는 메소드
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // 스택의 가장 위에 있는 데이터를 반환하는 메소드(삭제하지 않음)
    public int peek() {
        if (isEmpty()) {
            System.out.println("스택이 비어있습니다.");
            return -1; // 임의의 값으로 처리
        }
        return stackArray[top];
    }

    // 스택의 내용을 출력하는 메소드(디버깅용)
    public void display() {
        System.out.print("스택 내용: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }

    // 테스트를 위한 메인 메소드
    public static void main(String[] args) {
        MyStack stack = new MyStack(4); // 최대 크기가 5인 스택 생성

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.display(); // 스택 내용 출력: 1 2 3 4

        System.out.println("가장 위에 있는 데이터: " + stack.peek()); // 출력: 4

        stack.pop(); // 스택에서 데이터 제거
        stack.pop(); // 스택에서 데이터 제거

        stack.display(); // 스택 내용 출력: 1 2
    }
}