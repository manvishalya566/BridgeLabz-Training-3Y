package String;

import java.util.Scanner;

class VowelConsonantCount {

    static boolean isVowel(char ch) {
        ch = (char)(ch >= 'A' && ch <= 'Z' ? ch + 32 : ch);
        return (ch == 'a'||ch=='e'||ch=='i'||ch=='o'||ch=='u');
    }

    static int[] countVowelsConsonants(String text) {
        int vowels = 0, consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                if (isVowel(ch)) vowels++;
                else consonants++;
            }
        }
        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        int[] res = countVowelsConsonants(text);
        System.out.println("Vowels: " + res[0]);
        System.out.println("Consonants: " + res[1]);
    }
}

