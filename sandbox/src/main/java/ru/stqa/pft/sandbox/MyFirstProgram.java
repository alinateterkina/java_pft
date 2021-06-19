package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        new MyFirstProgram().main();
    }

    private void main() {
        task2();

        Square s= new Square(8);
        System.out.println("Площадь квадрата со стороной "+s.l+" = "+area(s));

        Rectangle r= new Rectangle(4,6);
        System.out.println("Площадь прямоугольника со сторонами "+r.a+" и "+r.b+" = "+area(r));

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

    public static double area(Square s) {
        return s.l*s.l;

    }
    public static  double area(Rectangle r){
        return r.a*r.b;
    }

}
