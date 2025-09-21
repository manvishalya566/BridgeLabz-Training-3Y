package Sceneriobasedproblems;

// Interface for payment abstraction
interface Payable {
    double calculatePayment();
}

// ------------------ PATIENT BASE CLASS ------------------
abstract class Patient {
    private String name;
    private int age;
    private String medicalHistory; // sensitive info

    // Overloaded constructors (normal admission)
    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
        this.medicalHistory = "Not available";
    }

    // Overloaded constructor (emergency admission with history)
    public Patient(String name, int age, String medicalHistory) {
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
    }

    // Encapsulation: controlled access
    public String getName() { return name; }
    public int getAge() { return age; }

    public String getSummary() {
        return "Patient: " + name + ", Age: " + age;
    }

    // Abstract method to demonstrate polymorphism
    public abstract void displayInfo();
}

// ------------------ SUBCLASSES ------------------
class InPatient extends Patient {
    private int roomNumber;

    public InPatient(String name, int age, String medicalHistory, int roomNumber) {
        super(name, age, medicalHistory);
        this.roomNumber = roomNumber;
    }

    @Override
    public void displayInfo() {
        System.out.println(getSummary() + " [In-Patient, Room " + roomNumber + "]");
    }
}

class OutPatient extends Patient {
    private String appointmentDate;

    public OutPatient(String name, int age, String medicalHistory, String appointmentDate) {
        super(name, age, medicalHistory);
        this.appointmentDate = appointmentDate;
    }

    @Override
    public void displayInfo() {
        System.out.println(getSummary() + " [Out-Patient, Appointment: " + appointmentDate + "]");
    }
}

// ------------------ DOCTOR CLASS ------------------
class Doctor {
    private String name;
    private String specialization;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public void displayInfo() {
        System.out.println("Doctor: " + name + " (Specialization: " + specialization + ")");
    }
}

// ------------------ BILL CLASS ------------------
class Bill implements Payable {
    private double baseAmount;
    private double discount;
    private double taxRate;

    public Bill(double baseAmount, double discount, double taxRate) {
        this.baseAmount = baseAmount;
        this.discount = discount;
        this.taxRate = taxRate;
    }

    // Payment calculation (abstraction via interface)
    @Override
    public double calculatePayment() {
        double discountedAmount = baseAmount - discount;
        double tax = discountedAmount * taxRate;
        return discountedAmount + tax;
    }

    // Simulating operator overloading with method
    public Bill combineBills(Bill other) {
        return new Bill(
                this.baseAmount + other.baseAmount,
                this.discount + other.discount,
                (this.taxRate + other.taxRate) / 2  // average tax rate
        );
    }

    public void printBill() {
        System.out.println("Base Amount: " + baseAmount);
        System.out.println("Discount: " + discount);
        System.out.println("Tax: " + (taxRate * 100) + "%");
        System.out.println("Total Payable: " + calculatePayment());
    }
}

// ------------------ MAIN SYSTEM ------------------
public class HospitalManagement {
    public static void main(String[] args) {
        // Creating Doctors
        Doctor doc1 = new Doctor("Dr. Smith", "Cardiology");

        // Creating Patients
        InPatient p1 = new InPatient("Alice", 45, "Heart issues", 101);
        OutPatient p2 = new OutPatient("Bob", 30, "Flu symptoms", "2025-09-20");

        // Display info
        doc1.displayInfo();
        p1.displayInfo();
        p2.displayInfo();

        // Billing Example
        Bill bill1 = new Bill(1000, 200, 0.18); // base=1000, discount=200, tax=18%
        Bill bill2 = new Bill(500, 50, 0.18);   // another bill

        System.out.println("\n--- Bill 1 ---");
        bill1.printBill();

        System.out.println("\n--- Bill 2 ---");
        bill2.printBill();

        // Combine bills (like operator overloading)
        Bill combined = bill1.combineBills(bill2);
        System.out.println("\n--- Combined Bill ---");
        combined.printBill();
    }
}
