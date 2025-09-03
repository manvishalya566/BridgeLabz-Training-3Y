package ClassandObject;

class Employee {
    // Instance variables
    String name;
    int id;
    double salary;

    // Constructor to initialize employee details
    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display employee details
    public void displayEmployee() {
        System.out.println("Employee Name   : " + name);
        System.out.println("Employee ID     : " + id);
        System.out.println("Employee Salary : ₹" + salary);
    }

    // Main method to test the Employee class
    public static void main(String[] args) {
        Employee emp = new Employee("Rohan", 1, 500000); // Creating object
        emp.displayEmployee(); // Displaying details
    }
}
