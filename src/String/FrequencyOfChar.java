package String;
import java.util.Scanner;

import java.util.Scanner;

class FrequencyOfChar {

    // Method to find unique characters
    static char[] uniqueCharacters(String text) {
        StringBuilder unique = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (unique.indexOf(String.valueOf(ch)) == -1) {
                unique.append(ch);
            }
        }
        return unique.toString().toCharArray();
    }

    // Method to find frequency using ASCII
    static String[][] findFrequency(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        char[] uniqueChars = uniqueCharacters(text);
        String[][] result = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = Character.toString(uniqueChars[i]);
            result[i][1] = Integer.toString(freq[uniqueChars[i]]);
        }
        return result;
    }

    // Print
    static void printResult(String[][] freqArr) {
        System.out.println("Character Frequencies:");
        for (String[] row : freqArr) {
            System.out.println("'" + row[0] + "' : " + row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[][] freqArr = findFrequency(text);
        printResult(freqArr);

        sc.close();
    }
}
