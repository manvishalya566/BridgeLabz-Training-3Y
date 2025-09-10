package Inheritance;

// Superclass Vehicle
class Vehicle {
    int maxSpeed;
    String fuelType;

    // Constructor
    Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    // Method to be overridden
    void displayInfo() {
        System.out.println("Vehicle Info:");
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Fuel Type: " + fuelType);
    }
}

// Subclass Car
class Car extends Vehicle {
    int seatCapacity;

    Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Car");
        System.out.println("Seat Capacity: " + seatCapacity);
        System.out.println("----------------------");
    }
}

// Subclass Truck
class Truck extends Vehicle {
    double loadCapacity; // in tons

    Truck(int maxSpeed, String fuelType, double loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Truck");
        System.out.println("Load Capacity: " + loadCapacity + " tons");
        System.out.println("----------------------");
    }
}

// Subclass Motorcycle
class Motorcycle extends Vehicle {
    String type; // e.g., Sports, Cruiser

    Motorcycle(int maxSpeed, String fuelType, String type) {
        super(maxSpeed, fuelType);
        this.type = type;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Motorcycle");
        System.out.println("Category: " + type);
        System.out.println("----------------------");
    }
}

// Demo Class
class VehicleTransportDemo {
    public static void main(String[] args) {
        // Creating subclass objects
        Vehicle car = new Car(220, "Petrol", 5);
        Vehicle truck = new Truck(120, "Diesel", 15.5);
        Vehicle bike = new Motorcycle(180, "Petrol", "Sports");

        // Store all in an array for polymorphism
        Vehicle[] vehicles = { car, truck, bike };

        // Display info using dynamic method calls
        for (Vehicle v : vehicles) {
            v.displayInfo();
        }
    }
}

