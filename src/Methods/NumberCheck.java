package Methods;

import java.util.Scanner;

class NumberCheck {

    public static int checkNumber(int num) {
        if (num > 0) return 1;
        if (num < 0) return -1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();

        int result = checkNumber(num);
        if (result == 1) System.out.println("Positive Number");
        else if (result == -1) System.out.println("Negative Number");
        else System.out.println("Zero");

        sc.close();
    }
}

