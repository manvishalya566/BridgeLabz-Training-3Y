package Methods;

import java.util.Scanner;

class TriangularPark {

    public static int computeRounds(int a, int b, int c) {
        int perimeter = a + b + c;
        int distance = 5000; // meters
        return distance / perimeter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side1: ");
        int a = sc.nextInt();
        System.out.print("Enter side2: ");
        int b = sc.nextInt();
        System.out.print("Enter side3: ");
        int c = sc.nextInt();

        int rounds = computeRounds(a, b, c);
        System.out.println("The athlete must complete " + rounds + " rounds to cover 5km");

        sc.close();
    }
}
