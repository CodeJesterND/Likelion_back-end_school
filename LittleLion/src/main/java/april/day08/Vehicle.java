package april.day08;

public class Vehicle {
    protected int speed;
    protected String color;

    public Vehicle(String color) {
        this.color = color;
        this.speed = 0;
    }

    public void increaseSpeed(int increment) {
        speed += increment;
        System.out.println("속도가 증가하였습니다. 현재 속도: " + speed + "km/h");
    }

    public void decreaseSpeed(int decrement) {
        speed -= decrement;
        if(speed < 0) {
            speed = 0;
        }
        System.out.println("속도가 감소하였습니다. 현재 속도: " + speed + "km/h");
    }
}
