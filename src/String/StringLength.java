package String;

import java.util.Scanner;

class StringLength {

    // Method to find length without using length()
    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count); // if out of range -> exception
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // loop ends here
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();

        int userLength = getLength(input);
        int builtinLength = input.length();

        System.out.println("Length (User-defined): " + userLength);
        System.out.println("Length (Built-in): " + builtinLength);
    }
}

