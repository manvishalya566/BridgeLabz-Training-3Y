package Constructor;

class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double dailyRate = 50.0;  // Example rate per day

    // Default constructor
    CarRental() {
        customerName = "Unknown";
        carModel = "Economy";
        rentalDays = 1;
    }

    // Parameterized constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    double calculateTotalCost() {
        return rentalDays * dailyRate;
    }

    void display() {
        System.out.println("Customer: " + customerName + ", Car: " + carModel +
                ", Days: " + rentalDays + ", Total: $" + calculateTotalCost());
    }
}

