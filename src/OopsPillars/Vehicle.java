package OopsPillars;

// Insurable Interface
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract Vehicle class
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Abstract method to calculate rental cost
    public abstract double calculateRentalCost(int days);

    // Getter and Setter methods
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }
}

// Car class
class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        // Insurance cost is 10% of rental rate per day
        return getRentalRate() * 0.10;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy: " + insurancePolicyNumber + ", Daily Insurance: $" + calculateInsurance();
    }

    // Encapsulation for insurancePolicyNumber
    public String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    public void setInsurancePolicyNumber(String insurancePolicyNumber) {
        this.insurancePolicyNumber = insurancePolicyNumber;
    }
}

// Bike class
class Bike extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        // Bikes get a 5% discount if rented more than 5 days
        double cost = getRentalRate() * days;
        if (days > 5) {
            cost *= 0.95;
        }
        return cost;
    }

    @Override
    public double calculateInsurance() {
        // Insurance cost is 5% of rental rate per day
        return getRentalRate() * 0.05;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy: " + insurancePolicyNumber + ", Daily Insurance: $" + calculateInsurance();
    }

    // Encapsulation for insurancePolicyNumber
    public String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    public void setInsurancePolicyNumber(String insurancePolicyNumber) {
        this.insurancePolicyNumber = insurancePolicyNumber;
    }
}

// Truck class
class Truck extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        // Trucks have an additional fixed surcharge of $50
        return getRentalRate() * days + 50;
    }

    @Override
    public double calculateInsurance() {
        // Insurance cost is 15% of rental rate per day
        return getRentalRate() * 0.15;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy: " + insurancePolicyNumber + ", Daily Insurance: $" + calculateInsurance();
    }

    // Encapsulation for insurancePolicyNumber
    public String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    public void setInsurancePolicyNumber(String insurancePolicyNumber) {
        this.insurancePolicyNumber = insurancePolicyNumber;
    }
}

// Main class to test the system
import java.util.ArrayList;

public class VehicleRentalSystem {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        Car car1 = new Car("CAR123", 100, "POLICY-CAR-001");
        Bike bike1 = new Bike("BIKE456", 40, "POLICY-BIKE-001");
        Truck truck1 = new Truck("TRUCK789", 200, "POLICY-TRUCK-001");

        vehicles.add(car1);
        vehicles.add(bike1);
        vehicles.add(truck1);

        int rentalDays = 7;

        // Polymorphism: iterate over vehicles and calculate costs
        for (Vehicle v : vehicles) {
            System.out.println("Vehicle Number: " + v.getVehicleNumber());
            System.out.println("Type: " + v.getType());
            System.out.println("Rental Cost for " + rentalDays + " days: $" + v.calculateRentalCost(rentalDays));

            if (v instanceof Insurable) {
                Insurable insurableVehicle = (Insurable) v;
                System.out.println(insurableVehicle.getInsuranceDetails());
                double totalCost = v.calculateRentalCost(rentalDays) + (insurableVehicle.calculateInsurance() * rentalDays);
                System.out.println("Total Cost including Insurance: $" + totalCost);
            }

            System.out.println("-------------------------");
        }
    }
}

