import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Shape {
    abstract double calculateArea();

    abstract double calculatePerimeter();

    abstract void draw();
}

class Rectangle extends Shape {
    private double width;
    private double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return width * height;
    }

    @Override
    double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    void draw() {
        System.out.println("Drawing a Rectangle");
    }
}


class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    void draw() {
        System.out.println("Drawing a Circle");
    }
}


class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    double calculateArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    double calculatePerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    void draw() {
        System.out.println("Drawing a Triangle");
    }
}


class ShapeFactory {
    static Shape createShape(int choice, Scanner scanner) {
        Shape shape = null;
        switch (choice) {
            case 1:
                shape = createRectangle(scanner);
                break;
            case 2:
                shape = createCircle(scanner);
                break;
            case 3:
                shape = createTriangle(scanner);
                break;
            default:
                System.out.println("Invalid choice!");
        }
        return shape;
    }

    private static Rectangle createRectangle(Scanner scanner) {
        System.out.print("Enter width and height of Rectangle: ");
        double width = scanner.nextDouble();
        double height = scanner.nextDouble();
        return new Rectangle(width, height);
    }

    private static Circle createCircle(Scanner scanner) {
        System.out.print("Enter radius of Circle: ");
        double radius = scanner.nextDouble();
        return new Circle(radius);
    }

    private static Triangle createTriangle(Scanner scanner) {
        System.out.print("Enter lengths of the three sides of Triangle: ");
        double side1 = scanner.nextDouble();
        double side2 = scanner.nextDouble();
        double side3 = scanner.nextDouble();
        return new Triangle(side1, side2, side3);
    }
}

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Shape> shapes = new ArrayList<>();

            System.out.println("Enter multiple shapes. Enter 4 to exit.");
            while (true) {
                System.out.println("Select a shape to create:");
                System.out.println("1. Rectangle");
                System.out.println("2. Circle");
                System.out.println("3. Triangle");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                if (choice == 4)
                    break;

                Shape shape = ShapeFactory.createShape(choice, scanner);
                if (shape != null) {
                    shapes.add(shape);
                }
            }

            for (Shape shape : shapes) {
                shape.draw();
                System.out.println("Area: " + shape.calculateArea());
                System.out.println("Perimeter: " + shape.calculatePerimeter());
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
