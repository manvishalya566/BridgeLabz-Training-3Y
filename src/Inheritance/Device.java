package Inheritance;

// Superclass Device
class Device {
    String deviceId;
    String status; // ON / OFF

    // Constructor
    Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    // Method to display general device status
    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

// Subclass Thermostat
class Thermostat extends Device {
    int temperatureSetting; // in Celsius

    // Constructor
    Thermostat(String deviceId, String status, int temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    // Overriding displayStatus to add specific details
    @Override
    void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
        System.out.println("----------------------");
    }
}

// Demo class
class SmartHomeDemo {
    public static void main(String[] args) {
        // Create Thermostat objects
        Thermostat t1 = new Thermostat("T001", "ON", 24);
        Thermostat t2 = new Thermostat("T002", "OFF", 18);

        // Display status
        t1.displayStatus();
        t2.displayStatus();
    }
}
