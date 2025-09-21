package Sceneriobasedproblems;

// -------------------------
// Interface for Appliance Control
// -------------------------
interface Controllable {
    void turnOn();
    void turnOff();
}

// -------------------------
// Abstract Appliance Class
// -------------------------
abstract class Appliance implements Controllable {
    private String name;
    private boolean isOn;
    private int power; // in watts

    public Appliance(String name, int power) {
        this.name = name;
        this.power = power; // user-defined or default setting
        this.isOn = false;  // default: off
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public boolean isOn() {
        return isOn;
    }

    protected void setOn(boolean on) {
        this.isOn = on;
    }

    // Compare energy usage between appliances
    public boolean usesMorePowerThan(Appliance other) {
        return this.power > other.power;
    }

    public boolean usesLessPowerThan(Appliance other) {
        return this.power < other.power;
    }

    public boolean usesEqualPowerAs(Appliance other) {
        return this.power == other.power;
    }
}

// -------------------------
// Light Class
// -------------------------
class Light extends Appliance {
    public Light(String name, int power) {
        super(name, power);
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println(getName() + " Light is ON (brightness set).");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println(getName() + " Light is OFF.");
    }
}

// -------------------------
// Fan Class
// -------------------------
class Fan extends Appliance {
    public Fan(String name, int power) {
        super(name, power);
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println(getName() + " Fan is ON (rotating at default speed).");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println(getName() + " Fan is OFF.");
    }
}

// -------------------------
// AC Class
// -------------------------
class AC extends Appliance {
    public AC(String name, int power) {
        super(name, power);
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println(getName() + " AC is ON (cooling mode).");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println(getName() + " AC is OFF.");
    }
}

// -------------------------
// User Controller Class
// -------------------------
class UserController {
    private String username;

    public UserController(String username) {
        this.username = username;
    }

    public void controlDevice(Appliance appliance, boolean turnOn) {
        if (turnOn) {
            appliance.turnOn();
        } else {
            appliance.turnOff();
        }
    }

    public void compareDevices(Appliance a1, Appliance a2) {
        if (a1.usesMorePowerThan(a2)) {
            System.out.println(a1.getName() + " uses more power than " + a2.getName());
        } else if (a1.usesLessPowerThan(a2)) {
            System.out.println(a1.getName() + " uses less power than " + a2.getName());
        } else {
            System.out.println(a1.getName() + " uses the same power as " + a2.getName());
        }
    }
}

// -------------------------
// Main Simulation Class
// -------------------------
public class SmartHomeApp {
    public static void main(String[] args) {
        // Create appliances with default or user-defined settings
        Appliance livingRoomLight = new Light("Living Room", 60);
        Appliance ceilingFan = new Fan("Ceiling", 75);
        Appliance bedroomAC = new AC("Bedroom", 1500);

        // User controller
        UserController user = new UserController("Alice");

        // Control devices
        user.controlDevice(livingRoomLight, true);
        user.controlDevice(ceilingFan, true);
        user.controlDevice(bedroomAC, true);

        user.controlDevice(ceilingFan, false);

        // Compare power usage
        user.compareDevices(livingRoomLight, bedroomAC);
        user.compareDevices(ceilingFan, livingRoomLight);
    }
}
