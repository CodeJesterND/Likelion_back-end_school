package april.day15;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ElectronicDeviceDemo {
    public static void main(String[] args) {
        ElectronicDevice tv = new Tv();
        tv.turnOff();
        tv.turnOn();

        ElectronicDevice computer = new Computer();
        computer.turnOn();
        computer.turnOff();

        List<String> list = new Vector<>();
        list.add("a");
        list.add("b");


    }
}
