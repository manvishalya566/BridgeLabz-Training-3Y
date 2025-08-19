package java_fundamentals;

import java.util.Scanner;

public class Volume {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the radius : ");
        double radius = scanner.nextDouble();
        System.out.print("Enter the height : ");
        double height = scanner.nextDouble();
        double volume = Math.PI * radius * radius * height;
        System.out.printf("The volume of the cylinder is:"+ volume);


    }
}
