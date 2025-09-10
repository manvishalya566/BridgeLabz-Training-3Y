package Inheritance;
// Base class Employee
class Employee {
    String name;
    int id;
    double salary;

    // Constructor
    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display common details
    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }
}

// Subclass Manager
class Manager extends Employee {
    int teamSize;

    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Manager");
        System.out.println("Team Size: " + teamSize);
        System.out.println("----------------------");
    }
}

// Subclass Developer
class Developer extends Employee {
    String programmingLanguage;

    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Developer");
        System.out.println("Programming Language: " + programmingLanguage);
        System.out.println("----------------------");
    }
}

// Subclass Intern
class Intern extends Employee {
    int duration; // in months

    Intern(String name, int id, double salary, int duration) {
        super(name, id, salary);
        this.duration = duration;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Intern");
        System.out.println("Internship Duration: " + duration + " months");
        System.out.println("----------------------");
    }
}

// Demo class
class EmployeeManagementDemo {
    public static void main(String[] args) {
        // Create objects of different employee types
        Employee manager = new Manager("Alice", 101, 90000, 10);
        Employee developer = new Developer("Bob", 102, 70000, "Java");
        Employee intern = new Intern("Charlie", 103, 20000, 6);

        // Polymorphism: Store all employees in one array
        Employee[] employees = { manager, developer, intern };

        // Display details of all employees
        for (Employee e : employees) {
            e.displayDetails();
        }
    }
}

