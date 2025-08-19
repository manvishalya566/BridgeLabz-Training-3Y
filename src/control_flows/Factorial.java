package control_flows;
import java.util.Scanner;

class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        // Check for positive integer
        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            long factorial = 1;  // use long in case result is big
            int i = 1;

            // while loop to compute factorial
            while (i <= number) {
                factorial *= i;
                i++;
            }

            System.out.println("Factorial of " + number + " is " + factorial);
        }

        sc.close();
    }
}
