package april.day15;

public class Computer implements ElectronicDevice{
    @Override
    public void turnOn() {
        System.out.println("컴퓨터의 전원을 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("컴퓨터의 전원을 끕니다.");
    }
}