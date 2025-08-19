package control_flows;
import java.util.Scanner;

class StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input marks
        System.out.print("Enter marks in Physics: ");
        int physics = sc.nextInt();
        System.out.print("Enter marks in Chemistry: ");
        int chemistry = sc.nextInt();
        System.out.print("Enter marks in Maths: ");
        int maths = sc.nextInt();

        // Total and percentage
        int totalMarks = physics + chemistry + maths;
        double percentage = totalMarks / 3.0;

        // Grade calculation
        String grade;
        if (percentage >= 90) {
            grade = "A";
        } else if (percentage >= 75) {
            grade = "B";
        } else if (percentage >= 50) {
            grade = "C";
        } else {
            grade = "F";
        }

        // Output
        System.out.println("Total Marks = " + totalMarks);
        System.out.println("Percentage = " + percentage + "%");
        System.out.println("Grade = " + grade);

        sc.close();
    }
}
