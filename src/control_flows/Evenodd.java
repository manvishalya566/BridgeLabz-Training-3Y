package control_flows;
import java.util.Scanner;

class OddEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Check if natural number
        if (number <= 0) {
            System.out.println("Please enter a natural number (positive integer).");
        } else {
            // Loop from 1 to number
            for (int i = 1; i <= number; i++) {
                if (i % 2 == 0) {
                    System.out.println(i + " is an even number");
                } else {
                    System.out.println(i + " is an odd number");
                }
            }
        }

        sc.close();
    }
}
