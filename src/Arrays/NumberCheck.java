package Arrays;

import java.util.Scanner;

class NumberCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int n : numbers) {
            if (n > 0) {
                if (n % 2 == 0)
                    System.out.println(n + " is Positive and Even");
                else
                    System.out.println(n + " is Positive and Odd");
            } else if (n < 0) {
                System.out.println(n + " is Negative");
            } else {
                System.out.println(n + " is Zero");
            }
        }

        // Compare first and last
        if (numbers[0] == numbers[numbers.length - 1]) {
            System.out.println("First and last elements are Equal.");
        } else if (numbers[0] > numbers[numbers.length - 1]) {
            System.out.println("First element is Greater than last.");
        } else {
            System.out.println("First element is Less than last.");
        }
    }
}
