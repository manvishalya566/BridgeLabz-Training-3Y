package Sceneriobasedproblems;

// -------------------------
// Transaction Interface
// -------------------------
interface ITransaction {
    void deposit(double amount);
    void withdraw(double amount);
    double checkBalance();
}

// -------------------------
// Abstract Account Class
// -------------------------
abstract class Account implements ITransaction {
    private String accountNumber;
    private double balance;  // private for encapsulation

    // Constructor without opening balance
    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    // Constructor with opening balance
    public Account(String accountNumber, double openingBalance) {
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // Only controlled modification of balance
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: ₹" + amount + " | New Balance: ₹" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount + " | New Balance: ₹" + balance);
        } else {
            System.out.println("Withdrawal failed: Insufficient funds or invalid amount.");
        }
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    protected double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Polymorphism: implemented differently in subclasses
    public abstract void calculateInterest();
}

// -------------------------
// Savings Account
// -------------------------
class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 4.0; // 4% per annum

    public SavingsAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    public SavingsAccount(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public void calculateInterest() {
        double interest = (getBalance() * INTEREST_RATE) / 100;
        System.out.println("Savings Account Interest: ₹" + interest);
        setBalance(getBalance() + interest); // add interest to balance
    }
}

// -------------------------
// Current Account
// -------------------------
class CurrentAccount extends Account {
    private static final double INTEREST_RATE = 0.0; // No interest

    public CurrentAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    public CurrentAccount(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public void calculateInterest() {
        double interest = (getBalance() * INTEREST_RATE) / 100;
        System.out.println("Current Account Interest: ₹" + interest + " (No interest applied)");
    }
}

// -------------------------
// Main Simulation
// -------------------------
public class MyBankApp {
    public static void main(String[] args) {
        // Create accounts
        SavingsAccount sa = new SavingsAccount("SAV1001", 5000);
        CurrentAccount ca = new CurrentAccount("CUR2001", 10000);

        // Perform transactions
        sa.deposit(2000);
        sa.withdraw(1000);
        System.out.println("Savings Balance: ₹" + sa.checkBalance());
        sa.calculateInterest();

        System.out.println("-------------------------");

        ca.deposit(5000);
        ca.withdraw(12000); // Should fail due to insufficient funds
        System.out.println("Current Balance: ₹" + ca.checkBalance());
        ca.calculateInterest();
    }
}
