package control_flows;
import java.util.Scanner;

class Age {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        // Check eligibility
        if (age >= 18) {
            System.out.println("You are eligible to vote.");
        } else {
            System.out.println("You are not eligible to vote.");
        }

        sc.close();
    }
}
