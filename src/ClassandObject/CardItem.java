package ClassandObject;

public class CardItem {
    // Attributes
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public CardItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to add quantity
    public void addItem(int quantityToAdd) {
        this.quantity += quantityToAdd;
        System.out.println("✅ Added " + quantityToAdd + " of " + itemName);
    }

    // Method to remove quantity
    public void removeItem(int quantityToRemove) {
        if (quantityToRemove > quantity) {
            System.out.println("⚠️ Cannot remove " + quantityToRemove + ". Only " + quantity + " available.");
        } else {
            quantity -= quantityToRemove;
            System.out.println("🗑️ Removed " + quantityToRemove + " of " + itemName);
        }
    }

    // Method to calculate total cost
    public double totalCost() {
        return price * quantity;
    }

    // Method to display item details
    public void displayItem() {
        System.out.println("🛍️ Item: " + itemName + " | Price: ₹" + price + " | Quantity: " + quantity);
    }

    // Getters (optional, useful for cart management)
    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
