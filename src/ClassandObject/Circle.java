package ClassandObject;

import java.util.Scanner;

public class Circle {
    // Instance variable
    double radius;

    // Constructor
    Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate and return area
    public double areaCircle() {
        return Math.PI * radius * radius;
    }

    // Method to calculate and return circumference
    public double circumferenceCircle() {
        return 2 * Math.PI * radius;
    }

    // Method to display both area and circumference
    public void displayDetails() {
        System.out.printf("Radius of circle       : %.2f\n", radius);
        System.out.printf("Area of circle         : %.4f\n", areaCircle());
        System.out.printf("Circumference of circle: %.4f\n", circumferenceCircle());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius of the circle: ");
        double inputRadius = sc.nextDouble();

        Circle circle = new Circle(inputRadius); // Constructor invocation
        circle.displayDetails(); // Displaying results
    }
}
