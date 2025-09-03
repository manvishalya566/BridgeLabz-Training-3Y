package ClassandObject;

public class MobilePhone {
    // Attributes
    private String brand;
    private String model;
    private double price;

    // Constructor
    public MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Method to display mobile phone details
    public void displayMobileDetails() {
        System.out.println("📱 Brand : " + brand);
        System.out.println("🔢 Model : " + model);
        System.out.println("💰 Price : ₹" + price);
        System.out.println("------------------------------");
    }

    // Main method
    public static void main(String[] args) {
        MobilePhone mobile1 = new MobilePhone("VIVO", "VIVO V29", 15999);
        MobilePhone mobile2 = new MobilePhone("ONE PLUS", "Nord 4", 39999);
        MobilePhone mobile3 = new MobilePhone("APPLE", "iPhone Pro 16", 79999);

        mobile1.displayMobileDetails();
        mobile2.displayMobileDetails();
        mobile3.displayMobileDetails();
    }
}
