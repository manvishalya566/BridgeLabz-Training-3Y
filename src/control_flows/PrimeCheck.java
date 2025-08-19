package control_flows;
import java.util.Scanner;

class PrimeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        boolean isPrime = true; // Assume number is prime initially

        if (num <= 1) {
            isPrime = false; // Numbers <= 1 are not prime
        } else {
            for (int i = 2; i <= num / 2; i++) { // Check divisibility up to num/2
                if (num % i == 0) {
                    isPrime = false; // Found a divisor
                    break; // No need to check further
                }
            }
        }

        if (isPrime) {
            System.out.println(num + " is a Prime Number.");
        } else {
            System.out.println(num + " is not a Prime Number.");
        }

        sc.close();
    }
}
