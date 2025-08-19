package java_fundamentals;

import java.util.Scanner;

public class Powercalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter base: ");
        double base = sc.nextDouble();

        System.out.print("Enter integer exponent: ");
        int exponent = sc.nextInt();

        double resultBuiltIn = Math.pow(base, exponent);
        double resultFast = fastPower(base, exponent);

        System.out.printf("Math.pow result: %.5f%n", resultBuiltIn);
        System.out.printf("Fast power result: %.5f%n", resultFast);

        sc.close();
    }

    public static double fastPower(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) return 1 / fastPower(x, -n);
        double temp = fastPower(x, n / 2);
        return (n % 2 == 0) ? temp * temp : x * temp * temp;
    }
}
