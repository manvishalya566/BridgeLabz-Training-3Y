package Arrays;

import java.util.Scanner;

class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] maths = new int[n];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks of student " + (i + 1) + " (Physics, Chemistry, Maths):");
            int p = sc.nextInt();
            int c = sc.nextInt();
            int m = sc.nextInt();
            if (p < 0 || c < 0 || m < 0) {
                System.out.println("Invalid marks. Try again.");
                i--; continue;
            }

            physics[i] = p; chemistry[i] = c; maths[i] = m;
            percentage[i] = (p + c + m) / 3.0;

            if (percentage[i] >= 90) grade[i] = 'A';
            else if (percentage[i] >= 75) grade[i] = 'B';
            else if (percentage[i] >= 50) grade[i] = 'C';
            else grade[i] = 'F';
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ": P=" + physics[i] + " C=" + chemistry[i] +
                    " M=" + maths[i] + " %=" + percentage[i] + " Grade=" + grade[i]);
        }
    }
}
