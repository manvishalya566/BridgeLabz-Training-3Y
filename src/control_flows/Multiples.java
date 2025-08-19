package control_flows;
import java.util.Scanner;

class MultiplesBelow100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a positive number less than 100: ");
        int number = sc.nextInt();

        // Validate input
        if (number <= 0 || number >= 100) {
            System.out.println("Please enter a positive integer less than 100.");
        } else {
            int counter = number; // start with the first multiple (the number itself)

            System.out.println("Multiples of " + number + " below 100:");

            // while loop to print multiples
            while (counter < 100) {
                System.out.println(counter);
                counter += number; // move to next multiple
            }
        }

        sc.close();
    }
}
