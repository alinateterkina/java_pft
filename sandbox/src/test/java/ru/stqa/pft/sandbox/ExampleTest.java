package ru.stqa.pft.sandbox;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void testMath() {
        int a = 2;
        int b = 2;
        int expectedSum = 4;
        assertEquals(expectedSum, a + b);
    }
}
