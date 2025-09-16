package OopsPillars;

// Discountable interface
interface Discountable {
    void applyDiscount(double discountPercentage);
    String getDiscountDetails();
}

// Abstract FoodItem class
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Abstract method to calculate total price
    public abstract double calculateTotalPrice();

    // Concrete method to display item details
    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Unit Price: $" + price);
        System.out.println("Quantity: " + quantity);
    }

    // Getters and Setters (Encapsulation)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

// VegItem class
class VegItem extends FoodItem implements Discountable {
    private double discount; // discount in percentage

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.discount = 0;
    }

    @Override
    public double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        total -= total * (discount / 100); // apply discount if any
        return total;
    }

    @Override
    public void applyDiscount(double discountPercentage) {
        this.discount = discountPercentage;
    }

    @Override
    public String getDiscountDetails() {
        return "Veg Item Discount: " + discount + "%";
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {
    private double discount; // discount in percentage
    private double additionalCharge; // e.g., handling/packaging fee

    public NonVegItem(String itemName, double price, int quantity, double additionalCharge) {
        super(itemName, price, quantity);
        this.discount = 0;
        this.additionalCharge = additionalCharge;
    }

    @Override
    public double calculateTotalPrice() {
        double total = (getPrice() * getQuantity()) + additionalCharge;
        total -= total * (discount / 100); // apply discount if any
        return total;
    }

    @Override
    public void applyDiscount(double discountPercentage) {
        this.discount = discountPercentage;
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg Item Discount: " + discount + "%, Additional Charge: $" + additionalCharge;
    }

    // Getter and Setter for additionalCharge
    public double getAdditionalCharge() {
        return additionalCharge;
    }

    public void setAdditionalCharge(double additionalCharge) {
        this.additionalCharge = additionalCharge;
    }
}

// Main class to test the system
import java.util.ArrayList;

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        ArrayList<FoodItem> order = new ArrayList<>();

        VegItem veg1 = new VegItem("Paneer Tikka", 10, 2);
        NonVegItem nonVeg1 = new NonVegItem("Chicken Burger", 12, 3, 2); // additional charge $2

        // Apply discounts
        veg1.applyDiscount(10); // 10% discount
        nonVeg1.applyDiscount(5); // 5% discount

        order.add(veg1);
        order.add(nonVeg1);

        // Process order polymorphically
        for (FoodItem item : order) {
            item.getItemDetails();
            if (item instanceof Discountable) {
                Discountable discountableItem = (Discountable) item;
                System.out.println(discountableItem.getDiscountDetails());
            }
            System.out.println("Total Price: $" + item.calculateTotalPrice());
            System.out.println("-----------------------------");
        }
    }
}

