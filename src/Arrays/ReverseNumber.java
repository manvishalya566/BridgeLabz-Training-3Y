package Arrays;

import java.util.Scanner;

class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        String str = String.valueOf(num);
        int[] digits = new int[str.length()];
        int[] reverse = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            digits[i] = str.charAt(i) - '0';
        }

        for (int i = 0; i < digits.length; i++) {
            reverse[i] = digits[digits.length - 1 - i];
        }

        System.out.print("Reversed Number: ");
        for (int d : reverse) System.out.print(d);
    }
}
