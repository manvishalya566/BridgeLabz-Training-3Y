package Sceneriobasedproblems;

// -------------------------
// Interface for Transfer
// -------------------------
interface Transferrable {
    void transferTo(User receiver, double amount);
}

// -------------------------
// User Class
// -------------------------
class User {
    private String name;
    private Wallet wallet;

    public User(String name, Wallet wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void viewBalance() {
        System.out.println(name + "'s Balance: " + wallet.getBalance());
    }

    public void viewTransactions() {
        System.out.println("Transaction History for " + name + ":");
        wallet.printTransactions();
    }
}

// -------------------------
// Abstract Wallet Class
// -------------------------
abstract class Wallet implements Transferrable {
    private double balance;
    private String walletId;
    private java.util.List<Transaction> transactions = new java.util.ArrayList<>();

    public Wallet(String walletId, double initialAmount, boolean referral) {
        this.walletId = walletId;
        this.balance = initialAmount;

        // Referral bonus logic
        if (referral) {
            this.balance += 50; // Referral credit
            transactions.add(new Transaction("Referral Bonus", 50));
        }
    }

    public double getBalance() {
        return balance;
    }

    protected void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
    }

    protected void withdraw(double amount) {
        balance -= amount;
        transactions.add(new Transaction("Withdrawal", -amount));
    }

    public void printTransactions() {
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    // Abstract (forces subclasses to implement rules)
    public abstract void transferTo(User receiver, double amount);

    protected void recordTransaction(String type, double amount) {
        transactions.add(new Transaction(type, amount));
    }
}

// -------------------------
// Personal Wallet
// -------------------------
class PersonalWallet extends Wallet {
    public PersonalWallet(String walletId, double initialAmount, boolean referral) {
        super(walletId, initialAmount, referral);
    }

    @Override
    public void transferTo(User receiver, double amount) {
        if (amount <= getBalance() && amount <= 5000) { // personal transfer limit
            withdraw(amount);
            receiver.getWallet().deposit(amount);
            recordTransaction("Transfer to " + receiver.getName(), -amount);
            System.out.println("Transferred " + amount + " to " + receiver.getName());
        } else {
            System.out.println("Transfer failed: Insufficient funds or exceeds limit.");
        }
    }
}

// -------------------------
// Business Wallet
// -------------------------
class BusinessWallet extends Wallet {
    public BusinessWallet(String walletId, double initialAmount, boolean referral) {
        super(walletId, initialAmount, referral);
    }

    @Override
    public void transferTo(User receiver, double amount) {
        double tax = amount * 0.02; // 2% transaction tax
        double total = amount + tax;

        if (total <= getBalance() && amount <= 50000) { // business transfer limit
            withdraw(total);
            receiver.getWallet().deposit(amount);
            recordTransaction("Business Transfer to " + receiver.getName(), -total);
            System.out.println("Transferred " + amount + " to " + receiver.getName() + " (Tax: " + tax + ")");
        } else {
            System.out.println("Business transfer failed: Insufficient funds or exceeds limit.");
        }
    }
}

// -------------------------
// Transaction Class
// -------------------------
class Transaction {
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return type + ": " + amount;
    }
}

// -------------------------
// Main Simulation
// -------------------------
public class EWalletApp {
    public static void main(String[] args) {
        Wallet aliceWallet = new PersonalWallet("PW101", 200, true);
        Wallet bobWallet = new BusinessWallet("BW202", 10000, false);

        User alice = new User("Alice", aliceWallet);
        User bob = new User("Bob", bobWallet);

        alice.viewBalance();
        bob.viewBalance();

        // Transfers
        alice.getWallet().transferTo(bob, 150);
        bob.getWallet().transferTo(alice, 2000);

        // View results
        alice.viewBalance();
        bob.viewBalance();

        alice.viewTransactions();
        bob.viewTransactions();
    }
}
