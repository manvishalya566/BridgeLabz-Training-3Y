package OopsPillars;

import java.util.ArrayList;

// MedicalRecord interface
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract Patient class
abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    // Constructor
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Abstract method to calculate bill
    public abstract double calculateBill();

    // Concrete method to display patient details
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Getters and Setters
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

// InPatient class
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;
    private ArrayList<String> medicalHistory;

    public InPatient(String patientId, String name, int age, int daysAdmitted, double dailyRate) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
        this.medicalHistory = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        // InPatient bill = daysAdmitted * dailyRate
        return daysAdmitted * dailyRate;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ":");
        for (String record : medicalHistory) {
            System.out.println("- " + record);
        }
    }

    // Getters and Setters
    public int getDaysAdmitted() {
        return daysAdmitted;
    }

    public void setDaysAdmitted(int daysAdmitted) {
        this.daysAdmitted = daysAdmitted;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }
}

// OutPatient class
class OutPatient extends Patient implements MedicalRecord {
    private int consultationFee;
    private ArrayList<String> medicalHistory;

    public OutPatient(String patientId, String name, int age, int consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.medicalHistory = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        // OutPatient bill = consultationFee
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ":");
        for (String record : medicalHistory) {
            System.out.println("- " + record);
        }
    }

    // Getter and Setter
    public int getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(int consultationFee) {
        this.consultationFee = consultationFee;
    }
}

// Main class to test the system
import java.util.ArrayList;

public class HospitalPatientManagement {
    public static void main(String[] args) {
        ArrayList<Patient> patients = new ArrayList<>();

        InPatient ip1 = new InPatient("IP101", "Alice", 30, 5, 500);
        ip1.addRecord("Appendectomy surgery done.");
        ip1.addRecord("Prescribed antibiotics for 7 days.");

        OutPatient op1 = new OutPatient("OP201", "Bob", 25, 150);
        op1.addRecord("Routine checkup.");
        op1.addRecord("Prescribed vitamin supplements.");

        patients.add(ip1);
        patients.add(op1);

        // Polymorphism: handle different patient types
        for (Patient p : patients) {
            p.getPatientDetails();
            System.out.println("Total Bill: $" + p.calculateBill());

            if (p instanceof MedicalRecord) {
                ((MedicalRecord) p).viewRecords();
            }

            System.out.println("-------------------------");
        }
    }
}
