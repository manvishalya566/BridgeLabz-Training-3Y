package Inheritance;

// Base class Course
class Course {
    String courseName;
    int duration; // in weeks

    // Constructor
    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    void displayCourseInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
    }
}

// Subclass OnlineCourse
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

// Subclass PaidOnlineCourse
class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount; // percentage

    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
        double finalPrice = fee - (fee * discount / 100);
        System.out.println("Final Price after discount: $" + finalPrice);
        System.out.println("----------------------");
    }
}

// Demo Class
class CourseHierarchyDemo {
    public static void main(String[] args) {
        // Create objects at different levels
        Course course = new Course("Introduction to CS", 8);
        OnlineCourse onlineCourse = new OnlineCourse("Data Structures", 10, "Coursera", true);
        PaidOnlineCourse paidCourse = new PaidOnlineCourse("Full-Stack Development", 12, "Udemy", true, 199.99, 20);

        // Store in array (polymorphism)
        Course[] courses = { course, onlineCourse, paidCourse };

        // Display info for each
        for (Course c : courses) {
            c.displayCourseInfo();
            System.out.println();
        }
    }
}
