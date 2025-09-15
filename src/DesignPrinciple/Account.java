package DesignPrinciple;

import java.util.ArrayList;

// Bank Account class
class Account {
    private static int nextAccountNumber = 1000;
    private int accountNumber;
    private double balance;

    // Constructor
    public Account() {
        this.accountNumber = nextAccountNumber++;
        this.balance = 0.0;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " into Account " + accountNumber);
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from Account " + accountNumber);
        } else {
            System.out.println("Insufficient balance in Account " + accountNumber);
        }
    }

    // Getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}

// Customer class
class Customer {
    private String name;
    private ArrayList<Account> accounts; // One customer can have multiple accounts

    // Constructor
    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    // Add account to this customer
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // View balances of all accounts
    public void viewBalance() {
        System.out.println("Customer: " + name);
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
        } else {
            for (Account acc : accounts) {
                System.out.println(" - Account " + acc.getAccountNumber() + ": $" + acc.getBalance());
            }
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }
}

// Bank class
class Bank {
    private String name;
    private ArrayList<Customer> customers; // Association: Bank has Customers

    // Constructor
    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    // Open a new account for a customer
    public void openAccount(Customer customer) {
        Account account = new Account();
        customer.addAccount(account);

        if (!customers.contains(customer)) {
            customers.add(customer);
        }

        System.out.println("Bank " + name + " opened Account " + account.getAccountNumber() + " for " + customer.getName());
    }

    // Show all customers of the bank
    public void showCustomers() {
        System.out.println("Bank: " + name + " has customers:");
        for (Customer c : customers) {
            System.out.println(" - " + c.getName());
        }
        System.out.println();
    }
}

// Main class
class main {
    public static void main(String[] args) {
        // Create a bank
        Bank myBank = new Bank("National Bank");

        // Create customers
        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");

        // Open accounts for customers
        myBank.openAccount(alice);
        myBank.openAccount(alice); // Alice opens a second account
        myBank.openAccount(bob);

        // Show bank customers
        myBank.showCustomers();

        // Deposit and withdraw money
        alice.viewBalance();
        bob.viewBalance();

        // Alice deposits in first account
        alice.viewBalance();
        alice.viewBalance();

        // Let's demonstrate deposits/withdraws
        alice.viewBalance();
    }
}
