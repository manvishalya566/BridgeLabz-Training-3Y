package String;

import java.util.Scanner;

class Frequency {

    // Method to find frequency of characters using ASCII values
    static String[][] findFrequency(String text) {
        int[] freq = new int[256]; // ASCII characters

        // Count frequencies
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Count unique characters
        int uniqueCount = 0;
        for (int f : freq) if (f > 0) uniqueCount++;

        // Store result in 2D array
        String[][] result = new String[uniqueCount][2];
        int idx = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                result[idx][0] = Character.toString((char) i);
                result[idx][1] = Integer.toString(freq[i]);
                idx++;
            }
        }
        return result;
    }

    // Print results
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
