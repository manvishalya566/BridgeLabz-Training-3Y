package programming_elements;

import java.util.Scanner;

public class UserInputExample {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your name: " );
        String name = scan.nextLine();

        System.out.print("Enter your age: " );
        int age = scan.nextInt();

        System.out.println("Hello, " + name + "! You are " + age + " years old.");

        scan.close();
    }
}