package april.day15;

public class GenericMethodExample2 {
    public static <T extends Number> T max(T x, T y, T z) {
        T max = x; // 초기 최댓값 설정

        if (y.doubleValue() > max.doubleValue()) {
            max = y; // y가 더 크면, max를 y로 업데이트
        }

        if(z.doubleValue() > max.doubleValue()) {
            max = z; // z가 더 크면, max를 z로 업데이트
        }

        return max; // 최댓값 반환
    }

    public static void main(String[] args) {
        // 제네릭 메소드 호출
        System.out.println("최댓값: " + max(3, 4, 5)); // 정수
        System.out.println("최댓값: " + max(6.6, 8.8, 7.7)); // 실수
        System.out.println("최댓값: " + max(15.5f, 11.1f, 9.9f)); // float
    }
}