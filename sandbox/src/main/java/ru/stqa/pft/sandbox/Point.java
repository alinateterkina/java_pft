package ru.stqa.pft.sandbox;

public class Point {

    public double x;
    public double y;

    public Point (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double distance(Point p1, Point p2) {
        double distance = Math.hypot(p2.x - p1.x, p2.y - p1.y); // TODO : peredelat
        return distance;
    }

    public double distanceTo(Point p) {
        double distance = Math.hypot(this.x - p.x, this.y - p.y);
        return distance;
    }
}