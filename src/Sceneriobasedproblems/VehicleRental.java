package Sceneriobasedproblems;
// ------------------ INTERFACE ------------------
interface Rentable {
    double calculateRent(int days);
}

// ------------------ VEHICLE BASE CLASS ------------------
abstract class Vehicle implements Rentable {
    protected String model;
    protected String registrationNumber;
    protected double baseRate;

    // Constructor
    public Vehicle(String model, String registrationNumber, double baseRate) {
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.baseRate = baseRate;
    }

    // Encapsulation via getters/setters
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }

    public double getBaseRate() { return baseRate; }
    public void setBaseRate(double baseRate) { this.baseRate = baseRate; }

    // Abstract method for polymorphic behavior
    public abstract void displayInfo();
}

// ------------------ BIKE CLASS ------------------
class Bike extends Vehicle {
    public Bike(String model, String registrationNumber, double baseRate) {
        super(model, registrationNumber, baseRate);
    }

    @Override
    public double calculateRent(int days) {
        // Example: no extra surcharges
        return baseRate * days;
    }

    @Override
    public void displayInfo() {
        System.out.println("Bike: " + model + " [" + registrationNumber + "], Rate: " + baseRate);
    }
}

// ------------------ CAR CLASS ------------------
class Car extends Vehicle {
    private boolean luxury;

    public Car(String model, String registrationNumber, double baseRate, boolean luxury) {
        super(model, registrationNumber, baseRate);
        this.luxury = luxury;
    }

    @Override
    public double calculateRent(int days) {
        // Luxury cars have surcharge
        double rent = baseRate * days;
        if (luxury) {
            rent += 500; // fixed luxury fee
        }
        return rent;
    }

    @Override
    public void displayInfo() {
        System.out.println("Car: " + model + " [" + registrationNumber + "], Rate: " + baseRate +
                (luxury ? " (Luxury)" : ""));
    }
}

// ------------------ TRUCK CLASS ------------------
class Truck extends Vehicle {
    private double loadCapacity; // in tons

    public Truck(String model, String registrationNumber, double baseRate, double loadCapacity) {
        super(model, registrationNumber, baseRate);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateRent(int days) {
        // Extra charge based on load capacity
        return (baseRate * days) + (loadCapacity * 100);
    }

    @Override
    public void displayInfo() {
        System.out.println("Truck: " + model + " [" + registrationNumber + "], Rate: " + baseRate +
                ", Load Capacity: " + loadCapacity + " tons");
    }
}

// ------------------ CUSTOMER CLASS ------------------
class Customer {
    private String name;
    private String licenseNumber;

    public Customer(String name, String licenseNumber) {
        this.name = name;
        this.licenseNumber = licenseNumber;
    }

    public String getName() { return name; }
    public String getLicenseNumber() { return licenseNumber; }

    public void displayInfo() {
        System.out.println("Customer: " + name + " (License: " + licenseNumber + ")");
    }
}

// ------------------ MAIN SYSTEM ------------------
public class VehicleRental {
    public static void main(String[] args) {
        // Create some vehicles
        Bike bike = new Bike("Yamaha R15", "BIK123", 200);
        Car car = new Car("Toyota Camry", "CAR456", 1000, true);
        Truck truck = new Truck("Volvo FH16", "TRK789", 1500, 10);

        // Create a customer
        Customer cust = new Customer("John Doe", "LIC998877");

        // Display details
        cust.displayInfo();
        bike.displayInfo();
        car.displayInfo();
        truck.displayInfo();

        // Rent calculation
        int days = 5;
        System.out.println("\n--- Rent Calculation for " + days + " days ---");
        System.out.println("Bike Rent: " + bike.calculateRent(days));
        System.out.println("Car Rent: " + car.calculateRent(days));
        System.out.println("Truck Rent: " + truck.calculateRent(days));
    }
}
