package ru.stqa.pft.sandbox;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class PointTest {

    @Test
    public void testHorizontalDistance() {
        Point p1 = new Point(1.0, 1.0);
        Point p2 = new Point(3.0, 1.0);
        double distanceExpected = 2.0;
        double distanceActual = p1.distanceTo(p2);
        assertEquals(distanceExpected, distanceActual);
    }
    public void testDistance() {
        Point p1 = new Point(-1.0, 2.0);
        Point p2 = new Point(-3.0, 4.0);
        double distanceExpected = 2.8284271247461903;
        double distanceActual = p1.distanceTo(p2);
        assertEquals(distanceExpected, distanceActual);
    }
}
