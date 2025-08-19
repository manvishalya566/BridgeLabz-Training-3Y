package control_flows;
import java.util.Scanner;

class CountDown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter countdown start number: ");
        int counter = sc.nextInt();

        // Countdown using while loop
        while (counter >= 1) {
            System.out.println(counter);
            counter--; // decrease counter
        }

        System.out.println("Liftoff! 🚀");

        sc.close();
    }
}
