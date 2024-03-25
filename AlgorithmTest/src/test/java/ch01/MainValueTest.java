package ch01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainValueTest {

    private MainValue mainValue;

    @Test
    void testMax() {
        System.out.println("최대값은 " + MainValue.max(13,14,15));
    }
}