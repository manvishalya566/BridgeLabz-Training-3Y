package DesignPrinciple;

class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Faculty(" + name + ")";
    }
}

class Main {
    private String name;

    public Main(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department(" + name + ")";
    }
}

class University {
    private String name;
    private java.util.List<Department> departments;
    private java.util.List<Faculty> faculty;

    public University(String name) {
        this.name = name;
        this.departments = new java.util.ArrayList<>(); // Composition
        this.faculty = new java.util.ArrayList<>();     // Aggregation
    }

    public void addDepartment(String departmentName) {
        Department dept = new Department(departmentName);
        departments.add(dept);
    }

    public void addFaculty(Faculty facultyMember) {
        faculty.add(facultyMember); // Aggregation: reference only
    }

    public void deleteUniversity() {
        System.out.println("Deleting University: " + name);
        for (Department dept : departments) {
            System.out.println("Deleting Department: " + dept);
        }
        departments.clear();
        faculty.clear();
    }

    @Override
    public String toString() {
        return "University(" + name + ", Departments=" + departments + ", Faculty=" + faculty + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        // Faculty members exist independently
        Faculty profJohn = new Faculty("John Smith");
        Faculty profJane = new Faculty("Jane Doe");

        // Create University
        University uni = new University("Tech University");

        // Add Departments (Composition)
        uni.addDepartment("Computer Science");
        uni.addDepartment("Mathematics");

        // Add Faculty (Aggregation)
        uni.addFaculty(profJohn);
        uni.addFaculty(profJane);

        System.out.println("Before deletion:");
        System.out.println(uni);

        // Delete the University → deletes departments, but faculty still exist
        System.out.println("\nDeleting university...");
        uni.deleteUniversity();

        System.out.println("\nFaculty still exists after University deletion:");
        System.out.println(profJohn);
        System.out.println(profJane);
    }
}