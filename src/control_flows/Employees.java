package control_flows;
import java.util.Scanner;

import java.util.Scanner;

class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter years of service: ");
        int years = sc.nextInt();

        // Bonus calculation
        if (years > 5) {
            double bonus = salary * 0.05; // 5% bonus
            System.out.println("Bonus amount: " + bonus);
        } else {
            System.out.println("No bonus (service must be more than 5 years).");
        }

        sc.close();
    }
}

