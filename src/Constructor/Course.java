package Constructor;

class Course {
    String courseName;
    int duration;   // in weeks
    double fee;
    static String instituteName = "ABC Institute";  // shared across all courses

    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    void displayCourseDetails() {
        System.out.println("Course: " + courseName + ", Duration: " + duration +
                " weeks, Fee: " + fee + ", Institute: " + instituteName);
    }

    static void updateInstituteName(String newName) {
        instituteName = newName;
    }
}
