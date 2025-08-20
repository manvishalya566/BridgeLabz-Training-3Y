package Methods;

import java.util.Scanner;

class Friends {

    public static String findYoungest(String[] names, int[] ages) {
        int minIdx = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[minIdx]) minIdx = i;
        }
        return names[minIdx];
    }

    public static String findTallest(String[] names, int[] heights) {
        int maxIdx = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[maxIdx]) maxIdx = i;
        }
        return names[maxIdx];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        int[] heights = new int[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = sc.nextInt();
            System.out.print("Enter height of " + names[i] + ": ");
            heights[i] = sc.nextInt();
        }

        System.out.println("Youngest: " + findYoungest(names, ages));
        System.out.println("Tallest: " + findTallest(names, heights));

        sc.close();
    }
}

