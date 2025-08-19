package control_flows;
import java.util.Scanner;

class PowerCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter the base number: ");
        int number = sc.nextInt();

        System.out.print("Enter the power: ");
        int power = sc.nextInt();

        int result = 1;   // initial value
        int counter = 0;  // to track loop count

        // while loop till counter == power
        while (counter < power) {
            result *= number;   // multiply result by number
            counter++;          // increment counter
        }

        System.out.println(number + " raised to the power " + power + " is " + result);

        sc.close();
    }
}
