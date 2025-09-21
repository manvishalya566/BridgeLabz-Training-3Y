package Sceneriobasedproblems;

// -------------------------
// Interface for Grading
// -------------------------
interface Graded {
    void assignGrade(Student student, Course course, String grade);
}

// -------------------------
// Abstract Student Class
// -------------------------
abstract class Student {
    private String name;
    private int id;
    private double totalPoints = 0;  // GPA calculation helper
    private int totalCourses = 0;    // GPA calculation helper

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Enroll in a course
    public void enroll(Course course) {
        Enrollment enrollment = new Enrollment(this, course);
        course.addEnrollment(enrollment);
        System.out.println(name + " enrolled in " + course.getCourseName());
    }

    // Add grade for GPA
    public void addGrade(double points) {
        totalPoints += points;
        totalCourses++;
    }

    // Calculate GPA
    public double getGPA() {
        return totalCourses == 0 ? 0 : totalPoints / totalCourses;
    }

    public String getTranscript() {
        return "Transcript for " + name + " (ID: " + id + ") | GPA: " + getGPA();
    }

    public String getName() {
        return name;
    }
}

// -------------------------
// Subclasses of Student
// -------------------------
class Undergraduate extends Student {
    public Undergraduate(String name, int id) {
        super(name, id);
    }
}

class Postgraduate extends Student {
    public Postgraduate(String name, int id) {
        super(name, id);
    }
}

// -------------------------
// Faculty Class
// -------------------------
class Faculty implements Graded {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    // Polymorphism: Letter grading
    @Override
    public void assignGrade(Student student, Course course, String grade) {
        double points;
        switch (grade) {
            case "A": points = 4.0; break;
            case "B": points = 3.0; break;
            case "C": points = 2.0; break;
            case "D": points = 1.0; break;
            case "F": points = 0.0; break;
            case "P": points = 3.0; break; // Pass/fail style
            case "F*": points = 0.0; break;
            default: points = 0.0; break;
        }
        student.addGrade(points);
        System.out.println("Faculty " + name + " assigned grade " + grade + " to " + student.getName());
    }
}

// -------------------------
// Course Class
// -------------------------
class Course {
    private String courseName;
    private int credits;

    public Course(String courseName, int credits) {
        this.courseName = courseName;
        this.credits = credits;
    }

    public String getCourseName() {
        return courseName;
    }

    // Stub for enrollments
    public void addEnrollment(Enrollment e) {
        // Could store list of students
    }
}

// -------------------------
// Enrollment Class
// -------------------------
class Enrollment {
    private Student student;
    private Course course;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }
}

// -------------------------
// Main Class (Simulation)
// -------------------------
public class UniversitySystem {
    public static void main(String[] args) {
        Student s1 = new Undergraduate("Alice", 101);
        Student s2 = new Postgraduate("Bob", 202);

        Course c1 = new Course("Data Structures", 4);
        Course c2 = new Course("Machine Learning", 3);

        Faculty f1 = new Faculty("Dr. Smith");

        s1.enroll(c1);
        s2.enroll(c2);

        // Assigning grades
        f1.assignGrade(s1, c1, "A");
        f1.assignGrade(s2, c2, "P"); // Pass/fail grading

        // Print transcripts
        System.out.println(s1.getTranscript());
        System.out.println(s2.getTranscript());
    }
}
