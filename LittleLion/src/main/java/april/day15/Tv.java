package april.day15;

public class Tv implements ElectronicDevice {
    @Override
    public void turnOn() {
        System.out.println("TV가 켜집니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV가 꺼집니다.");
    }
}