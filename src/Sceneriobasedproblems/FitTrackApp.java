package Sceneriobasedproblems;

import java.util.*;

// -------------------------
// Trackable Interface
// -------------------------
interface ITrackable {
    void startWorkout();
    void stopWorkout();
}

// -------------------------
// User Profile Class
// -------------------------
class UserProfile {
    private String name;
    private int age;
    private double weight; // private health data
    private double dailyCalorieGoal;
    private double caloriesBurnedToday;

    // Constructor with default goal
    public UserProfile(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.dailyCalorieGoal = 2000; // default daily calorie target
        this.caloriesBurnedToday = 0;
    }

    // Constructor with custom goal
    public UserProfile(String name, int age, double weight, double dailyCalorieGoal) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.dailyCalorieGoal = dailyCalorieGoal;
        this.caloriesBurnedToday = 0;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getWeight() { return weight; }
    public double getDailyCalorieGoal() { return dailyCalorieGoal; }

    public void logCalories(double calories) {
        caloriesBurnedToday += calories;
    }

    public double remainingCalories() {
        return dailyCalorieGoal - caloriesBurnedToday; // operator usage
    }

    public void printProgress() {
        System.out.println("User: " + name + " | Age: " + age +
                " | Goal: " + dailyCalorieGoal +
                " | Calories Burned Today: " + caloriesBurnedToday +
                " | Remaining: " + remainingCalories());
    }
}

// -------------------------
// Workout Class (Base)
// -------------------------
abstract class Workout implements ITrackable {
    private String type;
    private int duration; // in minutes
    private double caloriesBurned;

    public Workout(String type, int duration) {
        this.type = type;
        this.duration = duration;
        this.caloriesBurned = 0;
    }

    public String getType() { return type; }
    public int getDuration() { return duration; }
    public double getCaloriesBurned() { return caloriesBurned; }

    protected void setCaloriesBurned(double calories) {
        this.caloriesBurned = calories;
    }

    // Polymorphism: implemented differently in subclasses
    public abstract void calculateCalories();

    @Override
    public void startWorkout() {
        System.out.println(type + " workout started for " + duration + " minutes.");
    }

    @Override
    public void stopWorkout() {
        System.out.println(type + " workout stopped. Calories burned: " + caloriesBurned);
    }
}

// -------------------------
// Cardio Workout
// -------------------------
class CardioWorkout extends Workout {
    public CardioWorkout(int duration) {
        super("Cardio", duration);
    }

    @Override
    public void calculateCalories() {
        // Simple formula: 8 calories per minute
        double calories = getDuration() * 8;
        setCaloriesBurned(calories);
    }
}

// -------------------------
// Strength Workout
// -------------------------
class StrengthWorkout extends Workout {
    public StrengthWorkout(int duration) {
        super("Strength", duration);
    }

    @Override
    public void calculateCalories() {
        // Simple formula: 6 calories per minute
        double calories = getDuration() * 6;
        setCaloriesBurned(calories);
    }
}

// -------------------------
// Main Simulation
// -------------------------
public class FitTrackApp {
    public static void main(String[] args) {
        // Create user
        UserProfile user1 = new UserProfile("Alice", 25, 60.0, 1800);

        // Create workouts
        Workout cardio = new CardioWorkout(30);  // 30 min cardio
        Workout strength = new StrengthWorkout(45); // 45 min strength

        // Perform cardio
        cardio.startWorkout();
        cardio.calculateCalories();
        cardio.stopWorkout();
        user1.logCalories(cardio.getCaloriesBurned());

        // Perform strength
        strength.startWorkout();
        strength.calculateCalories();
        strength.stopWorkout();
        user1.logCalories(strength.getCaloriesBurned());

        // Print daily progress
        System.out.println("-------------------------");
        user1.printProgress();
    }
}

