package april.day08;

public class Car extends Vehicle {
    private int engineCapacity; // 엔진 용량

    public Car(String color, int engineCapacity) {
        super(color);
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void increaseSpeed(int increment) {
        increment += engineCapacity / 100; // 엔진 용량에 비례하여 속도 증가량 조정
        super.increaseSpeed(increment);
    }

    @Override
    public void decreaseSpeed(int decrement) {
        decrement += engineCapacity / 200; // 엔진 용량에 비례하여 속도 감소량 조정
        super.decreaseSpeed(decrement);
    }
}
