package control_flows;
import java.util.Scanner;

class LeapYearProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        // Part 1: Using multiple if-else statements
        if (year < 1582) {
            System.out.println("Year must be >= 1582 (Gregorian calendar).");
        } else if (year % 400 == 0) {
            System.out.println(year + " is a Leap Year.");
        } else if (year % 100 == 0) {
            System.out.println(year + " is not a Leap Year.");
        } else if (year % 4 == 0) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is not a Leap Year.");
        }

        // Part 2: Using a single if statement with multiple logical operators
        if (year >= 1582 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
            System.out.println(year + " is a Leap Year (Checked with single if).");
        } else if (year >= 1582) {
            System.out.println(year + " is not a Leap Year (Checked with single if).");
        } else {
            System.out.println("Year must be >= 1582 (Gregorian calendar).");
        }

        sc.close();
    }
}
