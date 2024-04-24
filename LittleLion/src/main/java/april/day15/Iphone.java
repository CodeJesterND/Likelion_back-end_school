package april.day15;

public class Iphone implements ElectronicDevice {
    @Override
    public void turnOn() {
        System.out.println("전원 켜짐");
    }

    @Override
    public void turnOff() {
        System.out.println("전원 꺼짐");
    }
}