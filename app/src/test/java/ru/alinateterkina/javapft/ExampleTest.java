package ru.alinateterkina.javapft;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void testMath() {
        int a = 2;
        int b = 2;
        int expectedSum = 4;
        assertEquals(expectedSum, a + b);
    }
}
