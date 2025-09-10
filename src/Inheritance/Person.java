package Inheritance;

// Superclass Person
class Person {
    String name;
    int age;

    // Constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Display common info
    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Subclass Teacher
class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    void displayRole() {
        displayInfo();
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
        System.out.println("----------------------");
    }
}

// Subclass Student
class Student extends Person {
    String grade;

    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    void displayRole() {
        displayInfo();
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
        System.out.println("----------------------");
    }
}

// Subclass Staff
class Staff extends Person {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    void displayRole() {
        displayInfo();
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
        System.out.println("----------------------");
    }
}

// Demo Class
class SchoolSystemDemo {
    public static void main(String[] args) {
        // Create objects
        Teacher t1 = new Teacher("Alice", 35, "Mathematics");
        Student s1 = new Student("Bob", 16, "10th Grade");
        Staff st1 = new Staff("Charlie", 40, "Administration");

        // Store in array for polymorphism
        Person[] people = { t1, s1, st1 };

        // Display roles using instanceof
        for (Person p : people) {
            if (p instanceof Teacher) {
                ((Teacher) p).displayRole();
            } else if (p instanceof Student) {
                ((Student) p).displayRole();
            } else if (p instanceof Staff) {
                ((Staff) p).displayRole();
            }
        }
    }
}
