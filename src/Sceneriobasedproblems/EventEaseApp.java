package Sceneriobasedproblems;

import java.util.*;

// -------------------------
// ISchedulable Interface
// -------------------------
interface ISchedulable {
    void schedule();
    void reschedule(String newDate);
    void cancel();
}

// -------------------------
// User Class (Organizer)
// -------------------------
class User {
    private String name;
    private String email;
    private String phone;

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
}

// -------------------------
// Event Base Class
// -------------------------
abstract class Event implements ISchedulable {
    private static int counter = 1000;
    private final int eventId; // once assigned, cannot be changed
    private String eventName;
    private String location;
    private String date;
    private int attendees;
    private User organizer;

    // Encapsulated pricing
    private double venueCost;
    private double serviceCost;
    private double discount;

    // Constructor without packages
    public Event(String eventName, String location, String date, int attendees, User organizer, double venueCost) {
        this.eventId = ++counter;
        this.eventName = eventName;
        this.location = location;
        this.date = date;
        this.attendees = attendees;
        this.organizer = organizer;
        this.venueCost = venueCost;
        this.serviceCost = 0;
        this.discount = 0;
    }

    // Constructor with packages
    public Event(String eventName, String location, String date, int attendees, User organizer, double venueCost, double serviceCost, double discount) {
        this.eventId = ++counter;
        this.eventName = eventName;
        this.location = location;
        this.date = date;
        this.attendees = attendees;
        this.organizer = organizer;
        this.venueCost = venueCost;
        this.serviceCost = serviceCost;
        this.discount = discount;
    }

    public int getEventId() { return eventId; }
    public String getEventName() { return eventName; }
    public String getDate() { return date; }
    public User getOrganizer() { return organizer; }

    // Cost calculation using operators
    public double calculateCost() {
        return (venueCost + serviceCost) - discount;
    }

    // Common cancel behavior
    @Override
    public void cancel() {
        System.out.println("Event " + eventName + " (ID: " + eventId + ") has been canceled.");
    }

    // Abstract methods to be polymorphic
    @Override
    public abstract void schedule();
    @Override
    public abstract void reschedule(String newDate);

    public void printDetails() {
        System.out.println("Event: " + eventName + " | ID: " + eventId +
                " | Location: " + location +
                " | Date: " + date +
                " | Attendees: " + attendees +
                " | Organizer: " + organizer.getName() +
                " | Total Cost: $" + calculateCost());
    }
}

// -------------------------
// Birthday Event
// -------------------------
class BirthdayEvent extends Event {
    public BirthdayEvent(String eventName, String location, String date, int attendees, User organizer, double venueCost) {
        super(eventName, location, date, attendees, organizer, venueCost);
    }

    public BirthdayEvent(String eventName, String location, String date, int attendees, User organizer, double venueCost, double serviceCost, double discount) {
        super(eventName, location, date, attendees, organizer, venueCost, serviceCost, discount);
    }

    @Override
    public void schedule() {
        System.out.println("🎂 Birthday Event '" + getEventName() + "' scheduled on " + getDate() +
                " by " + getOrganizer().getName());
    }

    @Override
    public void reschedule(String newDate) {
        System.out.println("🎂 Birthday Event '" + getEventName() + "' rescheduled to " + newDate);
    }
}

// -------------------------
// Conference Event
// -------------------------
class ConferenceEvent extends Event {
    public ConferenceEvent(String eventName, String location, String date, int attendees, User organizer, double venueCost) {
        super(eventName, location, date, attendees, organizer, venueCost);
    }

    public ConferenceEvent(String eventName, String location, String date, int attendees, User organizer, double venueCost, double serviceCost, double discount) {
        super(eventName, location, date, attendees, organizer, venueCost, serviceCost, discount);
    }

    @Override
    public void schedule() {
        System.out.println("🏢 Conference Event '" + getEventName() + "' scheduled on " + getDate() +
                " by " + getOrganizer().getName());
    }

    @Override
    public void reschedule(String newDate) {
        System.out.println("🏢 Conference Event '" + getEventName() + "' rescheduled to " + newDate);
    }
}

// -------------------------
// Main Simulation
// -------------------------
public class EventEaseApp {
    public static void main(String[] args) {
        User organizer1 = new User("Alice", "alice@email.com", "123456789");
        User organizer2 = new User("Bob", "bob@email.com", "987654321");

        Event birthday = new BirthdayEvent("Alice's Birthday", "Central Park", "2025-09-25", 50, organizer1, 500, 200, 50);
        Event conference = new ConferenceEvent("Tech Conference", "Expo Center", "2025-10-05", 300, organizer2, 2000, 1000, 300);

        birthday.schedule();
        birthday.printDetails();

        System.out.println("-----------------------------");

        conference.schedule();
        conference.printDetails();

        System.out.println("-----------------------------");
        birthday.reschedule("2025-09-30");
        conference.cancel();
    }
}

