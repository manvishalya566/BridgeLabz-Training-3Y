package OopsPillars;

// Loanable interface
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Abstract BankAccount class
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Concrete deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Concrete withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + " successfully.");
        } else {
            System.out.println("Invalid or insufficient funds for withdrawal.");
        }
    }

    // Abstract method to calculate interest
    public abstract double calculateInterest();

    // Getter and Setter methods
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: $" + balance);
    }
}

// SavingsAccount class
class SavingsAccount extends BankAccount implements Loanable {

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        // Savings account interest: 4% of balance
        return getBalance() * 0.04;
    }

    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println("Loan of $" + amount + " approved for Savings Account.");
        } else {
            System.out.println("Loan not approved. Insufficient balance.");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        // Eligible if balance >= 1000
        return getBalance() >= 1000;
    }
}

// CurrentAccount class
class CurrentAccount extends BankAccount implements Loanable {

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        // Current account: no interest
        return 0;
    }

    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println("Loan of $" + amount + " approved for Current Account.");
        } else {
            System.out.println("Loan not approved. Account must maintain minimum balance of $500.");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        // Eligible if balance >= 500
        return getBalance() >= 500;
    }
}

// Main class to test the banking system
import java.util.ArrayList;

public class BankingSystem {
    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<>();

        SavingsAccount sa = new SavingsAccount("SA101", "Alice", 2000);
        CurrentAccount ca = new CurrentAccount("CA201", "Bob", 800);

        accounts.add(sa);
        accounts.add(ca);

        // Polymorphism: process accounts
        for (BankAccount account : accounts) {
            account.displayAccountDetails();
            System.out.println("Interest: $" + account.calculateInterest());

            if (account instanceof Loanable) {
                Loanable loanableAccount = (Loanable) account;
                loanableAccount.applyForLoan(500);
                System.out.println("Loan Eligibility: " + loanableAccount.calculateLoanEligibility());
            }

            System.out.println("----------------------------");
        }

        // Testing deposit and withdraw
        sa.deposit(500);
        ca.withdraw(200);
    }
}

