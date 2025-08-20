package Arrays;

import java.util.Scanner;

class StudentGrades2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3];
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
            marks[i][0] = p; marks[i][1] = c; marks[i][2] = m;

            percentage[i] = (p + c + m) / 3.0;

            if (percentage[i] >= 90) grade[i] = 'A';
            else if (percentage[i] >= 75) grade[i] = 'B';
            else if (percentage[i] >= 50) grade[i] = 'C';
            else grade[i] = 'F';
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ": P=" + marks[i][0] +
                    " C=" + marks[i][1] +
                    " M=" + marks[i][2] +
                    " %=" + percentage[i] +
                    " Grade=" + grade[i]);
        }
    }
}
