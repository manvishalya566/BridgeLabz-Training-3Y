package Sceneriobasedproblems;

import java.util.*;

// -------------------------
// Base Class Person
// -------------------------
abstract class Person {
    private String name;
    private String email;
    private String id;

    public Person(String name, String email, String id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    // Polymorphism → implemented differently in Student and Faculty
    public abstract void printDetails();
}

// -------------------------
// Interface for Course Actions
// -------------------------
class Student extends Person implements ICourseActions {
    private Map<Course, Double> grades;  // private encapsulation
    private List<Course> enrolledCourses;

    public Student(String name, String email, String id) {
        super(name, email, id);  // call Person constructor
        this.grades = new HashMap<>();
        this.enrolledCourses = new ArrayList<>();
    }

   // @Override
    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
        course.addStudent(this);
        System.out.println(getName() + " enrolled in " + course.getCourseName());
    }

    //@Override
    public void dropCourse(Course course) {
        enrolledCourses.remove(course);
        course.removeStudent(this);
        System.out.println(getName() + " dropped " + course.getCourseName());
    }

    // Faculty assigns grade to student
    public void addGrade(Course course, double grade) {
        grades.put(course, grade);
    }

    // Calculate GPA (average of grades)
    public double calculateGPA() {
        if (grades.isEmpty()) return 0.0;
        double total = 0;
        for (double g : grades.values()) {
            total += g;
        }
        return total / grades.size();
    }

    @Override
    public void printDetails() {
        System.out.println("Student: " + getName() +
                " | Email: " + getEmail() +
                " | GPA: " + calculateGPA());
    }
}
// -------------------------
// Faculty Class
// -------------------------
class Faculty extends Person {
    private List<Course> assignedCourses;

    public Faculty(String name, String email, String id) {
        super(name, email, id);
        this.assignedCourses = new ArrayList<>();
    }

    public void assignCourse(Course course) {
        assignedCourses.add(course);
        course.setFaculty(this);
        System.out.println(getName() + " assigned to " + course.getCourseName());
    }

    // Faculty assigns grades to students
    public void assignGrade(Student student, Course course, double grade) {
        student.addGrade(course, grade);
        System.out.println("Faculty " + getName() + " assigned grade " + grade + " to " + student.getName());
    }

    @Override
    public void printDetails() {
        System.out.println("Faculty: " + getName() + " | Email: " + getEmail() +
                " | Courses Assigned: " + assignedCourses.size());
    }
}

// -------------------------
// Course Class
// -------------------------
class Course {
    private String courseCode;
    private String courseName;
    private Faculty faculty; // one faculty assigned
    private List<Student> students;

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void printCourseInfo() {
        System.out.println("Course: " + courseName + " | Code: " + courseCode +
                " | Faculty: " + (faculty != null ? faculty.getName() : "Not Assigned") +
                " | Enrolled Students: " + students.size());
    }
}

// -------------------------
// Main Simulation
// -------------------------
public class CampusConnectApp {
    public static void main(String[] args) {
        // Create faculty
        Faculty f1 = new Faculty("Dr. Sharma", "sharma@univ.edu", "F101");

        // Create courses
        Course c1 = new Course("CS101", "Data Structures");
        Course c2 = new Course("CS102", "Operating Systems");

        // Assign courses to faculty
        f1.assignCourse(c1);
        f1.assignCourse(c2);

        // Create students
        Student s1 = new Student("Alice", "alice@univ.edu", "S001");
        Student s2 = new Student("Bob", "bob@univ.edu", "S002");

        // Students enroll in courses
        s1.enrollCourse(c1);
        s2.enrollCourse(c1);
        s2.enrollCourse(c2);

        // Faculty assigns grades
        f1.assignGrade(s1, c1, 3.8);
        f1.assignGrade(s2, c1, 3.5);
        f1.assignGrade(s2, c2, 4.0);

        // Print details
        System.out.println("-------------------------");
        s1.printDetails();
        s2.printDetails();
        f1.printDetails();
        c1.printCourseInfo();
        c2.printCourseInfo();
    }
}

