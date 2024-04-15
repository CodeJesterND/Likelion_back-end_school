package april.day15.box;

// 상위 클래스 Box 정의
public class Box<T> {
    private T content;

    public Box(T content) {
        this.content = content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Box containing: " + content;
    }

    /*
    public static void main(String[] args) {
        Box<String> box = new Box<>("Hello world");
        System.out.println(box);
    }

     */
}