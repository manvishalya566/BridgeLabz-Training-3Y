package control_flows;
import java.util.Scanner;

class Loop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        int greatestFactor = 1;  // default (1 is always a factor)

        // loop from number - 1 down to 1
        for (int i = number - 1; i >= 1; i--) {
            if (number % i == 0) {    // check if divisible
                greatestFactor = i;   // found the greatest factor
                break;                // exit loop
            }
        }

        System.out.println("The greatest factor of " + number + " (beside itself) is " + greatestFactor);

        sc.close();
    }
}
