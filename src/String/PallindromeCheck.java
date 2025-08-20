package String;

import java.util.Scanner;

class PalindromeCheck {

    // Logic 1: Iterative
    static boolean isPalindromeIterative(String text) {
        int start = 0, end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive
    static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Logic 3: Using char arrays
    static boolean isPalindromeArray(String text) {
        char[] chars = text.toCharArray();
        char[] reverse = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            reverse[i] = text.charAt(chars.length - 1 - i);
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != reverse[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println("Iterative Palindrome Check: " + isPalindromeIterative(text));
        System.out.println("Recursive Palindrome Check: " + isPalindromeRecursive(text, 0, text.length() - 1));
        System.out.println("Array Palindrome Check: " + isPalindromeArray(text));

        sc.close();
    }
}
