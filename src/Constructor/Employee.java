package Constructor;

class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    Employee(int id, String dept, double salary) {
        this.employeeID = id;
        this.department = dept;
        this.salary = salary;
    }

    public void updateSalary(double newSalary) {
        this.salary = newSalary;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    String teamName;

    Manager(int id, String dept, double salary, String teamName) {
        super(id, dept, salary);
        this.teamName = teamName;
    }

    void display() {
        System.out.println("Manager ID: " + employeeID + ", Department: " + department +
                ", Salary: " + getSalary() + ", Team: " + teamName);
    }
}

