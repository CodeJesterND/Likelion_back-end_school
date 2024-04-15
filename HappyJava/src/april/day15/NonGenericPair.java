package april.day15;

public class NonGenericPair {
    private Object first;
    private Object second;

    public NonGenericPair(Object first, Object second) {
        this.first = first;
        this.second = second;
    }

    public Object getFirst() {
        return first;
    }

    public Object getSecond() {
        return second;
    }

    public void setFirst(Object first) {
        this.first = first;
    }

    public void setSecond(Object second) {
        this.second = second;
    }

    public static void main(String[] args) {
        NonGenericPair pair = new NonGenericPair("Hello", 5);
        String first = (String) pair.getFirst(); // 캐스팅 필요
        Integer second = (Integer) pair.getSecond(); // 캐스팅 필요

        Object firstObject = pair.getFirst();
        Object secondObject = pair.getSecond();
    }
}