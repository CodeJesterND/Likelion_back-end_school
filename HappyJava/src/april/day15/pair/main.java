package april.day15.pair;

public class main {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("Age", 30);
        String key = pair.getKey(); // "Age"
        Integer value = pair.getValue(); // 30

        System.out.println("Key: " + key + ", Value: " + value);
    }
}