package ru.stqa.pft.sandbox;

public class Square {
    public double l;
    public Square (double l){
        this.l = l;
    }

    public double area() {
        double area = l * l;
        return area;
    }

}
