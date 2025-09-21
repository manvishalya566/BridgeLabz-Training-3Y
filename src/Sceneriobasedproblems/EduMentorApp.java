package Sceneriobasedproblems;

import java.util.*;

// -------------------------
// Base User Class
// -------------------------
abstract class User {
    private String name;
    private String email;
    private String userId;

    public User(String name, String email, String userId) {
        this.name = name;
        this.email = email;
        this.userId = userId;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getUserId() { return userId; }

    public abstract void printDetails();
}

// -------------------------
// Certifiable Interface
// -------------------------
interface ICertifiable {
    void generateCertificate();
}

// -------------------------
// Learner Class
// -------------------------
class Learner extends User implements ICertifiable {
    private List<Course> enrolledCourses;
    private Map<Course, Quiz> courseQuizzes;

    public Learner(String name, String email, String userId) {
        super(name, email, userId);
        this.enrolledCourses = new ArrayList<>();
        this.courseQuizzes = new HashMap<>();
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
        System.out.println(getName() + " enrolled in course: " + course.getCourseName());
    }

    public void takeQuiz(Course course, Quiz quiz) {
        courseQuizzes.put(course, quiz);
        System.out.println(getName() + " completed quiz for course: " + course.getCourseName());
    }

    @Override
    public void generateCertificate() {
        for (Course course : enrolledCourses) {
            Quiz q = courseQuizzes.get(course);
            if (q != null && q.getPercentage() >= 50) {
                System.out.println("Certificate Granted to " + getName() +
                        " for course: " + course.getCourseName());
            } else {
                System.out.println(getName() + " has not passed course: " + course.getCourseName());
            }
        }
    }

    @Override
    public void printDetails() {
        System.out.println("Learner: " + getName() + " | Email: " + getEmail());
    }
}

// -------------------------
// Instructor Class
// -------------------------
class Instructor extends User {
    private List<Course> assignedCourses;

    public Instructor(String name, String email, String userId) {
        super(name, email, userId);
        this.assignedCourses = new ArrayList<>();
    }

    public void assignCourse(Course course) {
        assignedCourses.add(course);
        course.setInstructor(this);
        System.out.println(getName() + " assigned to course: " + course.getCourseName());
    }

    @Override
    public void printDetails() {
        System.out.println("Instructor: " + getName() + " | Email: " + getEmail() +
                " | Courses: " + assignedCourses.size());
    }
}

// -------------------------
// Course Class
// -------------------------
class Course {
    private String courseId;
    private String courseName;
    private Instructor instructor;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public String getCourseName() { return courseName; }
    public String getCourseId() { return courseId; }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}

// -------------------------
// Quiz Class
// -------------------------
class Quiz {
    private List<String> questions;   // private: internal bank
    private List<String> correctAnswers;
    private List<String> userAnswers;
    private int score;

    public Quiz(List<String> questions, List<String> correctAnswers) {
        this.questions = new ArrayList<>(questions);
        this.correctAnswers = new ArrayList<>(correctAnswers);
        this.userAnswers = new ArrayList<>();
        this.score = 0;
    }

    // Users can only submit answers once (no modification allowed after)
    public void submitAnswers(List<String> answers) {
        if (userAnswers.isEmpty()) {
            userAnswers.addAll(answers);
            calculateScore();
        } else {
            System.out.println("Answers already submitted. Cannot modify.");
        }
    }

    private void calculateScore() {
        int correctCount = 0;
        for (int i = 0; i < correctAnswers.size(); i++) {
            if (i < userAnswers.size() && userAnswers.get(i).equalsIgnoreCase(correctAnswers.get(i))) {
                correctCount++;
            }
        }
        score = correctCount;
    }

    public int getScore() { return score; }

    public double getPercentage() {
        return (score * 100.0) / correctAnswers.size();
    }
}

// -------------------------
// Main Simulation
// -------------------------
public class EduMentorApp {
    public static void main(String[] args) {
        // Instructor
        Instructor inst1 = new Instructor("Dr. Mehta", "mehta@edumentor.com", "I001");

        // Course
        Course javaCourse = new Course("C101", "Java Programming");
        inst1.assignCourse(javaCourse);

        // Learner
        Learner l1 = new Learner("Alice", "alice@mail.com", "L001");
        l1.enrollCourse(javaCourse);

        // Quiz for the course
        List<String> qns = Arrays.asList("What is JVM?", "Is Java platform-independent?");
        List<String> ans = Arrays.asList("Java Virtual Machine", "Yes");

        Quiz quiz = new Quiz(qns, ans);

        // Learner submits answers
        l1.takeQuiz(javaCourse, quiz);
        quiz.submitAnswers(Arrays.asList("Java Virtual Machine", "Yes"));

        // Print details
        System.out.println("-------------------------");
        inst1.printDetails();
        l1.printDetails();

        // Generate certificate based on performance
        l1.generateCertificate();
    }
}

