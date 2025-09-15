package DesignPrinciple;

import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

class Order {
    private List<Product> products = new ArrayList<>();
    private Customer customer;

    public Order(Customer customer) {
        this.customer = customer;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void showOrderDetails() {
        System.out.println("Order placed by " + customer + ":");
        for (Product product : products) {
            System.out.println("  - " + product);
        }
    }
}

class Customer {   // ✅ This is fine inside Problem4Demo.java
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public Order placeOrder() {
        return new Order(this);
    }

    @Override
    public String toString() {
        return "Customer(" + name + ")";
    }
}

class Problem4Demo {   // ✅ Must match the filename Problem4Demo.java
    public static void main(String[] args) {
        Customer customer = new Customer("Alice");
        Product laptop = new Product("Laptop", 1200);
        Product phone = new Product("Phone", 800);

        Order order = customer.placeOrder();
        order.addProduct(laptop);
        order.addProduct(phone);

        order.showOrderDetails();
    }
}
