package String;

import java.util.Scanner;

class IllegalArg{

    public static void generateException(String str) {
        System.out.println(str.substring(5, 2)); // invalid indices
    }

    public static void handleException(String str) {
        try {
            System.out.println(str.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Handled IllegalArgumentException: " + e);
        } catch (RuntimeException e) {
            System.out.println("Generic Exception: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.next();

        //generateException(str);
        handleException(str);
    }
}
