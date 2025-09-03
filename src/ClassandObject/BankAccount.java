package ClassandObject;

public class BankAccount {
    // Attributes
    private String accountHolder;
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to display bank name
    public static void displayBank() {
        System.out.println("\n\t🏦 Welcome to State of Chennai Bank\n");
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposited: ₹" + amount);
        } else {
            System.out.println("⚠️ Deposit amount must be positive.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("⚠️ Withdrawal amount must be positive.");
        } else if (amount <= balance) {
            balance -= amount;
            System.out.println("✅ Withdrawn: ₹" + amount);
        } else {
            System.out.println("❌ Insufficient balance.");
        }
    }

    // Method to display current balance
    public void displayBalance() {
        System.out.println("💰 Current Balance: ₹" + balance);
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("👤 Account Holder : " + accountHolder);
        System.out.println("🔢 Account Number : " + accountNumber);
        displayBalance();
    }

    // Main method
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Lynda", "123456789", 700.00);

        displayBank();
        account.displayAccountDetails();

        account.deposit(200.00);
        account.displayBalance();

        account.withdraw(100.00);
        account.displayBalance();

        account.withdraw(900.00); // Attempt to overdraw
    }
}
