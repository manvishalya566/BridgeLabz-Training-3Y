package java_fundamentals;

import java.util.Scanner;

public class Km {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter distance in kilometers: ");
        double km = scanner.nextDouble();

        double miles = km * 0.62137119;

        System.out.printf("%.3f km is ", km, miles);

    }
}
