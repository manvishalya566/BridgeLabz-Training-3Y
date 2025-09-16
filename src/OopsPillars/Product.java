package OopsPillars;

// Taxable Interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract Product class
abstract class Product {
    private int productId;
    private String name;
    private double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Abstract method for discount
    public abstract double calculateDiscount();

    // Getter and Setter methods
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

// Electronics class (taxable)
class Electronics extends Product implements Taxable {

    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        // Electronics have 10% discount
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax() {
        // Electronics tax 15%
        return getPrice() * 0.15;
    }

    @Override
    public String getTaxDetails() {
        return "Tax for Electronics: $" + calculateTax();
    }
}

// Clothing class (taxable)
class Clothing extends Product implements Taxable {

    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        // Clothing discount 20%
        return getPrice() * 0.20;
    }

    @Override
    public double calculateTax() {
        // Clothing tax 5%
        return getPrice() * 0.05;
    }

    @Override
    public String getTaxDetails() {
        return "Tax for Clothing: $" + calculateTax();
    }
}

// Groceries class (non-taxable)
class Groceries extends Product {

    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        // Groceries discount 5%
        return getPrice() * 0.05;
    }
}

// Main class to test the platform
import java.util.ArrayList;

public class ECommercePlatform {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();

        Electronics e1 = new Electronics(101, "Laptop", 1000);
        Clothing c1 = new Clothing(201, "T-Shirt", 50);
        Groceries g1 = new Groceries(301, "Rice", 20);

        products.add(e1);
        products.add(c1);
        products.add(g1);

        // Process products polymorphically
        for (Product p : products) {
            double finalPrice = p.getPrice() - p.calculateDiscount();
            System.out.println("Product: " + p.getName());
            System.out.println("Original Price: $" + p.getPrice());
            System.out.println("Discount: $" + p.calculateDiscount());

            if (p instanceof Taxable) {
                double tax = ((Taxable) p).calculateTax();
                finalPrice += tax;
                System.out.println(((Taxable) p).getTaxDetails());
            }

            System.out.println("Final Price: $" + finalPrice);
            System.out.println("-------------------------");
        }
    }
}

