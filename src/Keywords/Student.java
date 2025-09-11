package Keywords;


public class Student {

    // Static variable shared across all instances
    private static String universityName;
    private static int totalStudents = 0;

    // Instance variables
    private final int rollNumber; // Final variable ensures roll number cannot be changed
    private String name;
    private char grade;

    // Constructor using 'this' to initialize instance variables
    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++; // Increment total students whenever a new student is added
    }

    // Static method to set the university name
    public static void setUniversityName(String name) {
        universityName = name;
    }

    // Static method to display total number of students enrolled
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    // Method to display student details
    public void displayStudentDetails() {
        // Using instanceof to verify object's type
        if (this instanceof Student) {
            System.out.println("University Name: " + universityName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        } else {
            System.out.println("The object is not an instance of the Student class.");
        }
    }

    // Method to update the student's grade
    public void updateGrade(char newGrade) {
        // Using instanceof to verify object's type
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated to: " + newGrade);
        } else {
            System.out.println("The object is not an instance of the Student class.");
        }
    }

    // Getters for instance variables
    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public char getGrade() {
        return grade;
    }

    // Main method to test the Student class
    public static void main(String[] args) {
        // Set the university name
        Student.setUniversityName("Global University");

        // Create student instances
        Student student1 = new Student("Hemashree", 101, 'A');
        Student student2 = new Student("Sharmila", 102, 'B');

        // Display total students enrolled
        Student.displayTotalStudents();

        // Display student details
        student1.displayStudentDetails();
        System.out.println();
        student2.displayStudentDetails();

        // Update student grade
        student2.updateGrade('A');
        System.out.println();

        // Display updated student details
        student2.displayStudentDetails();
    }
}

