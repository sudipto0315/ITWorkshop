import java.util.Scanner;
abstract class Shape {
    public abstract double RectangleArea(double length, double breadth);
    public abstract double SquareArea(double side);
    public abstract double CircleArea(double radius);
}

class Area extends Shape {
    @Override
    public double RectangleArea(double length, double breadth) {
        double area = length * breadth;
        System.out.println("Area of Rectangle: " + area);
        return area;
    }

    @Override
    public double SquareArea(double side) {
        double area = side * side;
        System.out.println("Area of Square: " + area);
        return area;
    }

    @Override
    public double CircleArea(double radius) {
        double area = Math.PI * radius * radius;
        System.out.println("Area of Circle: " + area);
        return area;
    }
}

public class q1 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Area areaCalculator = new Area();

        System.out.print("Enter length of the rectangle: ");
        double length = scanner.nextDouble();

        System.out.print("Enter breadth of the rectangle: ");
        double breadth = scanner.nextDouble();

        System.out.print("Enter side of the square: ");
        double side = scanner.nextDouble();

        System.out.print("Enter radius of the circle: ");
        double radius = scanner.nextDouble();

        double rectangleArea = areaCalculator.RectangleArea(length, breadth);
        double squareArea = areaCalculator.SquareArea(side);
        double circleArea = areaCalculator.CircleArea(radius);

    }
}
