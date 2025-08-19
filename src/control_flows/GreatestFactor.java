package control_flows;
import java.util.Scanner;

class GreatestFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        int greatestFactor = 1;        // default (1 is always a factor)
        int counter = number - 1;      // start just below the number

        // while loop until counter reaches 1
        while (counter >= 1) {
            if (number % counter == 0) {   // check if perfectly divisible
                greatestFactor = counter;  // store greatest factor
                break;                     // stop after finding the first one
            }
            counter--;
        }

        System.out.println("The greatest factor of " + number + " (beside itself) is " + greatestFactor);

        sc.close();
    }
}
