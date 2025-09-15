package DesignPrinciple;

import java.util.ArrayList;

// Course class (associated with many students)
class Course {
    private String name;
    private ArrayList<Student> students; // association (many-to-many)

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    // Enroll a student in this course
    public void enrollStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.addCourse(this); // keep both sides in sync
        }
    }

    // Show all students in this course
    public void showStudents() {
        System.out.println("Course: " + name);
        if (students.isEmpty()) {
            System.out.println("  No students enrolled.");
        } else {
            for (Student s : students) {
                System.out.println("  - " + s.getName());
            }
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }
}

// Student class (associated with many courses)
class Student {
    private String name;
    private ArrayList<Course> courses; // association (many-to-many)

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // Add course (called internally by Course.enrollStudent)
    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    // View courses enrolled
    public void viewCourses() {
        System.out.println("Student: " + name);
        if (courses.isEmpty()) {
            System.out.println("  No courses enrolled.");
        } else {
            for (Course c : courses) {
                System.out.println("  - " + c.getName());
            }
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }
}

// School class (aggregation: has students)
class School {
    private String name;
    private ArrayList<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    // Add a student to the school
    public void addStudent(Student student) {
        students.add(student);
    }

    // Show all students in the school
    public void showStudents() {
        System.out.println("School: " + name + " Students:");
        if (students.isEmpty()) {
            System.out.println("  No students enrolled in the school.");
        } else {
            for (Student s : students) {
                System.out.println("  - " + s.getName());
            }
        }
        System.out.println();
    }
}

// ✅ Main class must match file name Main.java
class Main {
    public static void main(String[] args) {
        // Create school
        School school = new School("Greenwood High");

        // Create students
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");
        Student charlie = new Student("Charlie");

        // Add students to school (aggregation)
        school.addStudent(alice);
        school.addStudent(bob);
        school.addStudent(charlie);

        // Create courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");
        Course history = new Course("History");

        // Enroll students in courses (association)
        math.enrollStudent(alice);
        math.enrollStudent(bob);

        science.enrollStudent(alice);
        science.enrollStudent(charlie);

        history.enrollStudent(bob);

        // Show all students in school
        school.showStudents();

        // Each student views their courses
        alice.viewCourses();
        bob.viewCourses();
        charlie.viewCourses();

        // Each course shows its enrolled students
        math.showStudents();
        science.showStudents();
        history.showStudents();
    }
}
