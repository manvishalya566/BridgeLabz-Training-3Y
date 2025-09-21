package Sceneriobasedproblems;
// -------------------------
// Ride Service Interface
// -------------------------
interface IRideService {
    void bookRide(String pickup, String drop, double distance);
    void endRide();
}

// -------------------------
// Abstract Vehicle Class
// -------------------------
abstract class Vehicle {
    private String vehicleNumber;
    private int capacity;
    private String type;

    public Vehicle(String vehicleNumber, int capacity, String type) {
        this.vehicleNumber = vehicleNumber;
        this.capacity = capacity;
        this.type = type;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    // Abstract method → subclasses must implement
    public abstract double calculateFare(double distance);
}

// -------------------------
// Mini Vehicle
// -------------------------
class Mini extends Vehicle {
    private static final double BASE_FARE = 30;
    private static final double RATE = 8;

    public Mini(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity, "Mini");
    }

    @Override
    public double calculateFare(double distance) {
        return BASE_FARE + (distance * RATE);
    }
}

// -------------------------
// Sedan Vehicle
// -------------------------
class Sedan extends Vehicle {
    private static final double BASE_FARE = 50;
    private static final double RATE = 12;

    public Sedan(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity, "Sedan");
    }

    @Override
    public double calculateFare(double distance) {
        return BASE_FARE + (distance * RATE);
    }
}

// -------------------------
// SUV Vehicle
// -------------------------
class SUV extends Vehicle {
    private static final double BASE_FARE = 70;
    private static final double RATE = 15;

    public SUV(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity, "SUV");
    }

    @Override
    public double calculateFare(double distance) {
        return BASE_FARE + (distance * RATE);
    }
}

// -------------------------
// Driver Class
// -------------------------
class Driver {
    private String name;
    private String licenseNumber;
    private double rating; // private for encapsulation

    public Driver(String name, String licenseNumber, double rating) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public double getRating() {
        return rating;
    }
}

// -------------------------
// Ride Class (Encapsulation of fare & location)
// -------------------------
class Ride implements IRideService {
    private Vehicle vehicle;
    private Driver driver;
    private String pickup;
    private String drop;
    private double distance;
    private double fare; // private sensitive data
    private boolean isActive;

    public Ride(Vehicle vehicle, Driver driver) {
        this.vehicle = vehicle;
        this.driver = driver;
    }

    @Override
    public void bookRide(String pickup, String drop, double distance) {
        this.pickup = pickup;
        this.drop = drop;
        this.distance = distance;
        this.fare = vehicle.calculateFare(distance); // polymorphism
        this.isActive = true;

        System.out.println("Ride booked with " + driver.getName() +
                " (" + vehicle.getType() + ") from " + pickup + " to " + drop);
    }

    @Override
    public void endRide() {
        if (isActive) {
            System.out.println("Ride ended at " + drop + ". Fare: ₹" + fare);
            isActive = false;
        } else {
            System.out.println("No active ride to end.");
        }
    }

    public double getFare() {
        return fare;
    }

    public boolean isActive() {
        return isActive;
    }
}

// -------------------------
// Main Simulation
// -------------------------
public class CabbyGoApp {
    public static void main(String[] args) {
        // Create vehicles
        Vehicle mini = new Mini("MH12AB1234", 4);
        Vehicle sedan = new Sedan("MH14CD5678", 4);
        Vehicle suv = new SUV("MH16EF9012", 6);

        // Create drivers
        Driver d1 = new Driver("Raj", "LIC123", 4.8);
        Driver d2 = new Driver("Simran", "LIC456", 4.6);
        Driver d3 = new Driver("Amit", "LIC789", 4.9);

        // Book rides
        Ride ride1 = new Ride(mini, d1);
        ride1.bookRide("Pune Station", "Hinjewadi", 12.5);
        ride1.endRide();

        System.out.println("-------------------------");

        Ride ride2 = new Ride(suv, d3);
        ride2.bookRide("Baner", "Airport", 22.0);
        ride2.endRide();
    }
}
