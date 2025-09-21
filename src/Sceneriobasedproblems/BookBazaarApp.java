package Sceneriobasedproblems;

import java.util.*;

// -------------------------
// IDiscountable Interface
// -------------------------
interface IDiscountable {
    double applyDiscount();
}

// -------------------------
// Base Book Class
// -------------------------
abstract class Book implements IDiscountable {
    private String title;
    private String author;
    private double price;
    private int stock;  // encapsulated

    public Book(String title, String author, double price, int stock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    // Encapsulated stock update
    public void reduceStock(int quantity) {
        if (quantity <= stock) {
            stock -= quantity;
        } else {
            System.out.println("Not enough stock for " + title);
        }
    }

    public abstract double applyDiscount(); // polymorphic behavior
}

// -------------------------
// EBook Class
// -------------------------
class EBook extends Book {
    public EBook(String title, String author, double price, int stock) {
        super(title, author, price, stock);
    }

    @Override
    public double applyDiscount() {
        // EBooks always get 20% discount
        return getPrice() * 0.8;
    }
}

// -------------------------
// PrintedBook Class
// -------------------------
class PrintedBook extends Book {
    public PrintedBook(String title, String author, double price, int stock) {
        super(title, author, price, stock);
    }

    @Override
    public double applyDiscount() {
        // Printed books have 10% discount
        return getPrice() * 0.9;
    }
}

// -------------------------
// Order Class
// -------------------------
class Order {
    private static int counter = 100;
    private final int orderId;
    private String userName;
    private Map<Book, Integer> items; // Book and quantity
    private boolean isConfirmed; // restricted access

    public Order(String userName) {
        this.orderId = ++counter;
        this.userName = userName;
        this.items = new HashMap<>();
        this.isConfirmed = false;
    }

    public void addBook(Book book, int quantity) {
        if (book.getStock() >= quantity) {
            items.put(book, items.getOrDefault(book, 0) + quantity);
            book.reduceStock(quantity);
            System.out.println(quantity + " x " + book.getTitle() + " added to order.");
        } else {
            System.out.println("Insufficient stock for " + book.getTitle());
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<Book, Integer> entry : items.entrySet()) {
            Book book = entry.getKey();
            int qty = entry.getValue();
            total += book.applyDiscount() * qty; // price × quantity – discount
        }
        return total;
    }

    public void confirmOrder() {
        isConfirmed = true;
        System.out.println("Order #" + orderId + " confirmed for " + userName);
    }

    public void printOrderDetails() {
        System.out.println("------ Order #" + orderId + " ------");
        System.out.println("User: " + userName);
        for (Map.Entry<Book, Integer> entry : items.entrySet()) {
            Book book = entry.getKey();
            int qty = entry.getValue();
            System.out.println(book.getTitle() + " x" + qty + " @ $" + book.applyDiscount() + " each");
        }
        System.out.println("Total: $" + String.format("%.2f", calculateTotal()));
        System.out.println("Confirmed: " + isConfirmed);
        System.out.println("---------------------------");
    }
}

// -------------------------
// Main Simulation
// -------------------------
public class BookBazaarApp {
    public static void main(String[] args) {
        // Create books
        Book ebook1 = new EBook("Java Programming", "Alice Smith", 50, 100);
        Book printed1 = new PrintedBook("Data Structures", "Bob Lee", 80, 50);

        // Create order
        Order order1 = new Order("John Doe");
        order1.addBook(ebook1, 2);
        order1.addBook(printed1, 1);

        // Calculate total & confirm
        order1.printOrderDetails();
        order1.confirmOrder();
        order1.printOrderDetails();
    }
}

