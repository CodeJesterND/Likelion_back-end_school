package april.day08;

public class Bicycle extends Vehicle {
    private int gearCount; // 기어 수

    public Bicycle(String color, int gearCount) {
        super(color);
        this.gearCount = gearCount;
    }

    @Override
    public void increaseSpeed(int increment) {
        increment += gearCount * 2; // 기어 수에 비례하여 속도 증가량 조정
        super.increaseSpeed(increment);
    }

    @Override
    public void decreaseSpeed(int decrement) {
        decrement += gearCount; // 기어 수에 비례하여 속도 감소량 조정
        super.decreaseSpeed(decrement);
    }
}
