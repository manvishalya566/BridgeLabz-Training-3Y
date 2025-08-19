package control_flows;
import java.util.Scanner;

class PowerOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter the base number: ");
        int number = sc.nextInt();

        System.out.print("Enter the power: ");
        int power = sc.nextInt();

        // Check for valid (non-negative) power
        if (power < 0) {
            System.out.println("Please enter a non-negative power.");
        } else {
            int result = 1;

            // for loop to calculate power
            for (int i = 1; i <= power; i++) {
                result *= number;
            }

            System.out.println(number + " raised to the power " + power + " is " + result);
        }

        sc.close();
    }
}
