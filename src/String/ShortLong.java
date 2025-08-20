package String;

import java.util.Scanner;

class ShortLong {

    static String[] splitWords(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') count++;
        }
        String[] words = new String[count + 1];
        int idx = 0;
        String temp = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                temp += text.charAt(i);
            } else {
                words[idx++] = temp;
                temp = "";
            }
        }
        words[idx] = temp;
        return words;
    }

    static int strLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (Exception e) {}
        return count;
    }

    static String[][] wordWithLength(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(strLength(words[i]));
        }
        return result;
    }

    static int[] shortestLongest(String[][] arr) {
        int minIdx = 0, maxIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            int len = Integer.parseInt(arr[i][1]);
            if (len < Integer.parseInt(arr[minIdx][1])) minIdx = i;
            if (len > Integer.parseInt(arr[maxIdx][1])) maxIdx = i;
        }
        return new int[]{minIdx, maxIdx};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] words = splitWords(text);
        String[][] arr = wordWithLength(words);

        int[] res = shortestLongest(arr);

        System.out.println("Shortest Word: " + arr[res[0]][0]);
        System.out.println("Longest Word: " + arr[res[1]][0]);
    }
}

