package april.day15.nongenericpair;

public class NonGenericPairExam {
    public static void main(String[] args) {
        NonGenericPair pair = new NonGenericPair("Hello", 5);
        String first = (String) pair.getFirst(); // 캐스팅 필요
        Integer second = (Integer) pair.getSecond(); // 캐스팅 필요
    }
}