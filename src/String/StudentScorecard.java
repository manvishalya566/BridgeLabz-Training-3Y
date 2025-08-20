package String;

import java.util.Scanner;

class StudentScorecard {

    // Method 1: Generate random 2-digit scores for PCM subjects
    static int[][] generateScores(int n) {
        int[][] scores = new int[n][3];  // PCM
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = (int)(Math.random() * 41) + 60; // random score 60-100
            }
        }
        return scores;
    }

    // Method 2: Calculate total, average, and percentage
    static double[][] calculateResults(int[][] scores) {
        int n = scores.length;
        double[][] results = new double[n][3]; // total, average, percentage
        for (int i = 0; i < n; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;
            // Round to 2 decimal places
            avg = Math.round(avg * 100.0) / 100.0;
            percent = Math.round(percent * 100.0) / 100.0;

            results[i][0] = total;
            results[i][1] = avg;
            results[i][2] = percent;
        }
        return results;
    }

    // Method 3: Assign grade based on percentage
    static String[] assignGrades(double[][] results) {
        int n = results.length;
        String[] grades = new String[n];
        for (int i = 0; i < n; i++) {
            double percent = results[i][2];
            if (percent >= 90) grades[i] = "A+";
            else if (percent >= 80) grades[i] = "A";
            else if (percent >= 70) grades[i] = "B";
            else if (percent >= 60) grades[i] = "C";
            else if (percent >= 50) grades[i] = "D";
            else grades[i] = "F";
        }
        return grades;
    }

    // Method 4: Display the scorecard
    static void displayScorecard(int[][] scores, double[][] results, String[] grades) {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Stu\tPhysics\tChemistry\tMaths\tTotal\tAverage\t\t%age\tGrade");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < scores.length; i++) {
            System.out.println(
                    (i+1) + "\t" +
                            scores[i][0] + "\t" +
                            scores[i][1] + "\t\t" +
                            scores[i][2] + "\t" +
                            (int)results[i][0] + "\t" +
                            results[i][1] + "\t\t" +
                            results[i][2] + "\t" +
                            grades[i]
            );
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] scores = generateScores(n);
        double[][] results = calculateResults(scores);
        String[] grades = assignGrades(results);

        displayScorecard(scores, results, grades);
    }
}

