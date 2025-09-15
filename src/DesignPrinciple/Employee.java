package DesignPrinciple;
import java.util.ArrayList;

// Employee class
class Employee {
    private String name;
    private String role;

    // Constructor
    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    // Display employee info
    @Override
    public String toString() {
        return name + " (" + role + ")";
    }
}

// Department class (part of Company)
class Department {
    private String name;
    private ArrayList<Employee> employees;

    // Constructor
    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    // Add employee to department
    public void addEmployee(String name, String role) {
        employees.add(new Employee(name, role));
    }

    // Show all employees in this department
    public void showEmployees() {
        System.out.println("Department: " + name);
        if (employees.isEmpty()) {
            System.out.println("  No employees.");
        } else {
            for (Employee e : employees) {
                System.out.println("  - " + e);
            }
        }
    }

    public String getName() {
        return name;
    }
}

// Company class (composition: owns Departments)
class Company {
    private String name;
    private ArrayList<Department> departments;

    // Constructor
    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    // Add department to company
    public Department addDepartment(String deptName) {
        Department dept = new Department(deptName);
        departments.add(dept);
        return dept;
    }

    // Show all departments and employees
    public void showCompanyStructure() {
        System.out.println("Company: " + name);
        if (departments.isEmpty()) {
            System.out.println("No departments available.");
        } else {
            for (Department d : departments) {
                d.showEmployees();
            }
        }
        System.out.println();
    }

    // Delete company (composition effect: clear everything)
    public void deleteCompany() {
        System.out.println("Deleting company: " + name);
        departments.clear(); // removes all departments and employees
    }
}

// Main class
class mMain {
    public static void main(String[] args) {
        // Create company
        Company myCompany = new Company("TechCorp");

        // Add departments
        Department hr = myCompany.addDepartment("Human Resources");
        Department it = myCompany.addDepartment("IT");
        Department finance = myCompany.addDepartment("Finance");

        // Add employees
        hr.addEmployee("Alice", "HR Manager");
        hr.addEmployee("Bob", "Recruiter");

        it.addEmployee("Charlie", "System Admin");
        it.addEmployee("David", "Software Engineer");

        finance.addEmployee("Eve", "Accountant");

        // Show company structure
        myCompany.showCompanyStructure();

        // Delete company (composition effect)
        myCompany.deleteCompany();

        // Try showing company again (should be empty)
        myCompany.showCompanyStructure();
    }
}

