package Sceneriobasedproblems;

import java.util.*;

// -------------------------
// IApprovable Interface
// -------------------------
interface IApprovable {
    boolean approveLoan();
    double calculateEMI();
}

// -------------------------
// Applicant Class
// -------------------------
class Applicant {
    private String name;
    private int creditScore;  // sensitive data, encapsulated
    private double income;
    private double loanAmount;

    public Applicant(String name, int creditScore, double income, double loanAmount) {
        this.name = name;
        this.creditScore = creditScore;
        this.income = income;
        this.loanAmount = loanAmount;
    }

    public String getName() { return name; }
    public double getIncome() { return income; }
    public double getLoanAmount() { return loanAmount; }
    protected int getCreditScore() { return creditScore; } // protected for LoanEvaluation use only
}

// -------------------------
// Base Loan Application
// -------------------------
abstract class LoanApplication implements IApprovable {
    private static int counter = 1000;
    private final int applicationId;
    private String loanType;
    private int termMonths;
    private double interestRate; // annual
    private Applicant applicant;

    private boolean approved; // internal loan status

    public LoanApplication(String loanType, int termMonths, double interestRate, Applicant applicant) {
        this.applicationId = ++counter;
        this.loanType = loanType;
        this.termMonths = termMonths;
        this.interestRate = interestRate;
        this.applicant = applicant;
        this.approved = false;
    }

    public int getApplicationId() { return applicationId; }
    public String getLoanType() { return loanType; }
    public Applicant getApplicant() { return applicant; }
    public int getTermMonths() { return termMonths; }
    public double getInterestRate() { return interestRate; }
    public boolean isApproved() { return approved; }

    protected void setApproved(boolean approved) { // restricted access
        this.approved = approved;
    }

    // EMI Formula: [P × R × (1+R)^N] / [(1+R)^N – 1]
    protected double calculateEMIFormula(double principal, double annualRate, int termMonths) {
        double monthlyRate = annualRate / (12 * 100);
        double numerator = principal * monthlyRate * Math.pow(1 + monthlyRate, termMonths);
        double denominator = Math.pow(1 + monthlyRate, termMonths) - 1;
        return numerator / denominator;
    }

    // Default approval logic (overridable if needed)
    @Override
    public boolean approveLoan() {
        Applicant app = this.getApplicant();
        boolean eligible = app.getCreditScore() >= 650 && app.getIncome() > app.getLoanAmount() / getTermMonths();
        setApproved(eligible);
        return eligible;
    }

    // Abstract EMI calculation (polymorphic)
    @Override
    public abstract double calculateEMI();

    public void printDetails() {
        System.out.println("Loan ID: " + applicationId +
                " | Type: " + loanType +
                " | Applicant: " + applicant.getName() +
                " | Amount: $" + applicant.getLoanAmount() +
                " | Term: " + termMonths + " months" +
                " | Rate: " + interestRate + "%" +
                " | Approved: " + approved);
    }
}

// -------------------------
// Home Loan
// -------------------------
class HomeLoan extends LoanApplication {
    public HomeLoan(int termMonths, double interestRate, Applicant applicant) {
        super("Home Loan", termMonths, interestRate, applicant);
    }

    @Override
    public double calculateEMI() {
        double emi = calculateEMIFormula(getApplicant().getLoanAmount(), getInterestRate(), getTermMonths());
        return emi * 0.95; // 5% subsidy for home loans
    }
}

// -------------------------
// Auto Loan
// -------------------------
class AutoLoan extends LoanApplication {
    public AutoLoan(int termMonths, double interestRate, Applicant applicant) {
        super("Auto Loan", termMonths, interestRate, applicant);
    }

    @Override
    public double calculateEMI() {
        double emi = calculateEMIFormula(getApplicant().getLoanAmount(), getInterestRate(), getTermMonths());
        return emi * 1.02; // 2% processing fee included
    }
}

// -------------------------
// Personal Loan
// -------------------------
class PersonalLoan extends LoanApplication {
    public PersonalLoan(int termMonths, double interestRate, Applicant applicant) {
        super("Personal Loan", termMonths, interestRate, applicant);
    }

    @Override
    public double calculateEMI() {
        return calculateEMIFormula(getApplicant().getLoanAmount(), getInterestRate(), getTermMonths());
    }
}

// -------------------------
// Main Simulation
// -------------------------
public class LoanBuddyApp {
    public static void main(String[] args) {
        Applicant alice = new Applicant("Alice", 720, 6000, 20000);
        Applicant bob = new Applicant("Bob", 580, 3000, 15000);

        LoanApplication homeLoan = new HomeLoan(120, 7.5, alice);
        LoanApplication autoLoan = new AutoLoan(60, 9.0, bob);
        LoanApplication personalLoan = new PersonalLoan(24, 12.5, alice);

        // Process loans
        System.out.println("----- Loan Decisions -----");
        System.out.println("Home Loan Approved? " + homeLoan.approveLoan());
        System.out.println("Auto Loan Approved? " + autoLoan.approveLoan());
        System.out.println("Personal Loan Approved? " + personalLoan.approveLoan());

        // Print details + EMI
        System.out.println("\n----- Loan Details -----");
        homeLoan.printDetails();
        System.out.println("Monthly EMI: $" + String.format("%.2f", homeLoan.calculateEMI()));

        System.out.println("-----------------------------");
        autoLoan.printDetails();
        System.out.println("Monthly EMI: $" + String.format("%.2f", autoLoan.calculateEMI()));

        System.out.println("-----------------------------");
        personalL

