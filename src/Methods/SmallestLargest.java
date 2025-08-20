package Methods;

import java.util.Scanner;

class SmallestLargest {

    public static int[] findSmallestAndLargest(int a, int b, int c) {
        int smallest = a;
        int largest = a;

        if (b < smallest) smallest = b;
        if (c < smallest) smallest = c;

        if (b > largest) largest = b;
        if (c > largest) largest = c;

        return new int[]{smallest, largest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number1: ");
        int n1 = sc.nextInt();
        System.out.print("Enter number2: ");
        int n2 = sc.nextInt();
        System.out.print("Enter number3: ");
        int n3 = sc.nextInt();

        int[] result = findSmallestAndLargest(n1, n2, n3);
        System.out.println("Smallest = " + result[0] + ", Largest = " + result[1]);

        sc.close();
    }
}

