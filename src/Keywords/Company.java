package Keywords;


public class Company {

    // Static variable shared by all employees
    private static String companyName;
    private static int totalEmployees = 0;

    // Instance variables
    private String name;
    private final int id; // Final variable ensures employee ID cannot be changed
    private String designation;

    // Constructor using 'this' to initialize instance variables
    public Company(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++; // Increment total employees whenever a new employee is created
    }

    // Static method to set the company name
    public static void setCompanyName(String name) {
        companyName = name;
    }

    // Static method to display the total number of employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Method to display employee details
    public void displayEmployeeDetails() {
        // Using 'instanceof' to verify the object's type
        if (this instanceof Company) {
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
            System.out.println("----------------------");
        } else {
            System.out.println("The object is not an instance of the Employee class.");
        }
    }

    // Getters for instance variables (optional)
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    // Main method to test the class
    public static void main(String[] args) {
        // Set the company name (static variable)
        Company.setCompanyName("Tech Solutions Inc.");

        // Create new employee instances
        Company emp1 = new Company("Thamarai", 101, "Software Engineer");
        Company emp2 = new Company("Rohan", 102, "Project Manager");

        // Display total number of employees
        Company.displayTotalEmployees();

        // Display employee details
        emp1.displayEmployeeDetails();
        emp2.displayEmployeeDetails();
    }
}
