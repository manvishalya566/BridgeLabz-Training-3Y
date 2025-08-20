package String;

import java.util.Scanner;

class CustomTrim {

    static int[] trimIndexes(String text) {
        int start = 0, end = text.length() - 1;
        while (start < text.length() && text.charAt(start) == ' ') start++;
        while (end >= 0 && text.charAt(end) == ' ') end--;
        return new int[]{start, end};
    }

    static String substringCustom(String text, int start, int end) {
        String res = "";
        for (int i = start; i <= end; i++) {
            res += text.charAt(i);
        }
        return res;
    }

    static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text with spaces: ");
        String text = sc.nextLine();

        int[] idx = trimIndexes(text);
        String customTrimmed = substringCustom(text, idx[0], idx[1]);
        String builtinTrimmed = text.trim();

        System.out.println("Custom Trim: [" + customTrimmed + "]");
        System.out.println("Built-in Trim: [" + builtinTrimmed + "]");
        System.out.println("Are they same? " + compareStrings(customTrimmed, builtinTrimmed));
    }
}

