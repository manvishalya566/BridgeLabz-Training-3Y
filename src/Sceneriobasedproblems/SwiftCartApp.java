package Sceneriobasedproblems;

import java.util.*;

// -------------------------
// Base Product Class
// -------------------------
class Product {
    private String name;
    private double price;
    private String category;
    private int quantity;

    public Product(String name, double price, String category, int quantity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public int getQuantity() { return quantity; }

    // total cost of this product
    public double getTotalPrice() {
        return price * quantity;
    }

    // polymorphic discount behavior
    public double getDiscountedPrice() {
        return getTotalPrice(); // no discount by default
    }
}

// -------------------------
// Perishable Product
// -------------------------
class PerishableProduct extends Product {
    public PerishableProduct(String name, double price, int quantity) {
        super(name, price, "Perishable", quantity);
    }

    @Override
    public double getDiscountedPrice() {
        // 10% discount on perishable items
        return getTotalPrice() * 0.9;
    }
}

// -------------------------
// Non-Perishable Product
// -------------------------
class NonPerishableProduct extends Product {
    public NonPerishableProduct(String name, double price, int quantity) {
        super(name, price, "Non-Perishable", quantity);
    }

    @Override
    public double getDiscountedPrice() {
        // 5% discount on non-perishable items
        return getTotalPrice() * 0.95;
    }
}

// -------------------------
// Checkout Interface
// -------------------------
interface ICheckout {
    void generateBill();
    void applyDiscount();
}

// -------------------------
// Cart Class
// -------------------------
class Cart implements ICheckout {
    private List<Product> products;
    private double totalPrice; // encapsulated

    // Empty cart
    public Cart() {
        this.products = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    // Cart with pre-selected products
    public Cart(List<Product> initialProducts) {
        this.products = new ArrayList<>(initialProducts);
        calculateTotal(); // encapsulated calculation
    }

    public void addProduct(Product product) {
        products.add(product);
        calculateTotal();
        System.out.println(product.getName() + " added to cart.");
    }

    public void removeProduct(Product product) {
        products.remove(product);
        calculateTotal();
        System.out.println(product.getName() + " removed from cart.");
    }

    private void calculateTotal() {
        totalPrice = 0.0;
        for (Product p : products) {
            totalPrice += p.getTotalPrice();
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public void applyDiscount() {
        double discountedTotal = 0.0;
        for (Product p : products) {
            discountedTotal += p.getDiscountedPrice();
        }
        totalPrice = discountedTotal; // encapsulated update
        System.out.println("Discounts applied. New total: ₹" + totalPrice);
    }

    @Override
    public void generateBill() {
        System.out.println("\n------ SwiftCart Bill ------");
        for (Product p : products) {
            System.out.println(p.getName() + " (" + p.getCategory() + ") x" + p.getQuantity() +
                    " = ₹" + p.getTotalPrice());
        }
        System.out.println("Total (after discounts): ₹" + totalPrice);
        System.out.println("----------------------------\n");
    }
}

// -------------------------
// Main Simulation
// -------------------------
public class SwiftCartApp {
    public static void main(String[] args) {
        // Create products
        Product milk = new PerishableProduct("Milk", 50, 2);
        Product rice = new NonPerishableProduct("Rice", 80, 1);
        Product apples = new PerishableProduct("Apples", 120, 3);

        // Create cart and add products
        Cart cart = new Cart();
        cart.addProduct(milk);
        cart.addProduct(rice);
        cart.addProduct(apples);

        // Show total before discounts
        System.out.println("Cart Total (before discounts): ₹" + cart.getTotalPrice());

        // Apply discounts and generate final bill
        cart.applyDiscount();
        cart.generateBill();
    }
}

