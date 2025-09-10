package Inheritance;

// Superclass BankAccount
class BankAccount {
    String accountNumber;
    double balance;

    // Constructor
    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Display common account info
    void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}

// Subclass SavingsAccount
class SavingsAccount extends BankAccount {
    double interestRate; // percentage

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void displayAccountType() {
        displayAccountInfo();
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("----------------------");
    }
}

// Subclass CheckingAccount
class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        displayAccountInfo();
        System.out.println("Account Type: Checking Account");
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
        System.out.println("----------------------");
    }
}

// Subclass FixedDepositAccount
class FixedDepositAccount extends BankAccount {
    int maturityPeriod; // in months

    FixedDepositAccount(String accountNumber, double balance, int maturityPeriod) {
        super(accountNumber, balance);
        this.maturityPeriod = maturityPeriod;
    }

    void displayAccountType() {
        displayAccountInfo();
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Maturity Period: " + maturityPeriod + " months");
        System.out.println("----------------------");
    }
}

// Demo Class
class BankDemo {
    public static void main(String[] args) {
        // Create different account objects
        SavingsAccount savings = new SavingsAccount("S001", 5000, 4.5);
        CheckingAccount checking = new CheckingAccount("C001", 3000, 1000);
        FixedDepositAccount fd = new FixedDepositAccount("F001", 10000, 12);

        // Store in array for polymorphism
        BankAccount[] accounts = { savings, checking, fd };

        // Display details (downcasting needed for subclass-specific method)
        for (BankAccount account : accounts) {
            if (account instanceof SavingsAccount) {
                ((SavingsAccount) account).displayAccountType();
            } else if (account instanceof CheckingAccount) {
                ((CheckingAccount) account).displayAccountType();
            } else if (account instanceof FixedDepositAccount) {
                ((FixedDepositAccount) account).displayAccountType();
            }
        }
    }
}

