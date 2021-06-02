package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        new MyFirstProgram().main();
    }

    private void main() {
        task2();

        double a = 4;
        double b = 6;
        System.out.println("Площадь прямоугольника со сторонами "+a+" и "+b+" = "+area(a,b));

    }

    private void task2() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1,3);
        double distanceStatic = Point.distance(p1, p2);
        double distanceObject = p1.distanceTo(p2);
        System.out.println(distanceObject);
    }

    public void hello(String somebody) {
        System.out.println("Hello,"+somebody+"!");

    }

    public static double area(double len) {
        return len*len;

    }
    public static  double area(double a, double b){
        return a*b;
    }

}
