package java_fundamentals;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("Enter the third number: ");
        double num3 = scanner.nextDouble();

        double sum = num1 + num2 + num3;
        double average = sum / 3;

        System.out.println("Sum of the three numbers = " + sum);
        System.out.println("Average of the three numbers = " + average);

    }


}
