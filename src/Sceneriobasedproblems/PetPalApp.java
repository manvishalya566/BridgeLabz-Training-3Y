package Sceneriobasedproblems;

import java.util.*;

// -------------------------
// Interactable Interface
// -------------------------
interface IInteractable {
    void feed();
    void play();
    void sleep();
}

// -------------------------
// Base Pet Class
// -------------------------
abstract class Pet implements IInteractable {
    private String name;
    private String type;
    private int age;

    // Encapsulated states
    private int hunger;   // 0 = full, 100 = very hungry
    private int mood;     // 0 = sad, 100 = very happy
    private int energy;   // 0 = tired, 100 = energetic

    // Constructor with user-defined values
    public Pet(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.hunger = 50; // default moderate values
        this.mood = 50;
        this.energy = 50;
    }

    // Constructor with random defaults
    public Pet(String name, String type) {
        this.name = name;
        this.type = type;
        this.age = new Random().nextInt(10) + 1; // random age between 1–10
        this.hunger = new Random().nextInt(101);
        this.mood = new Random().nextInt(101);
        this.energy = new Random().nextInt(101);
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public int getAge() { return age; }

    // Encapsulated getters (no setters to prevent direct tampering)
    public int getHunger() { return hunger; }
    public int getMood() { return mood; }
    public int getEnergy() { return energy; }

    // Internal methods to modify state
    protected void changeHunger(int value) {
        hunger = Math.max(0, Math.min(100, hunger + value));
    }

    protected void changeMood(int value) {
        mood = Math.max(0, Math.min(100, mood + value));
    }

    protected void changeEnergy(int value) {
        energy = Math.max(0, Math.min(100, energy + value));
    }

    // Default interactions
    @Override
    public void feed() {
        changeHunger(-30); // decrease hunger
        changeMood(10);
        System.out.println(name + " is eating... Yum! Hunger: " + hunger);
    }

    @Override
    public void play() {
        changeEnergy(-20);
        changeMood(20);
        changeHunger(15);
        System.out.println(name + " is playing! Mood: " + mood + " | Energy: " + energy);
    }

    @Override
    public void sleep() {
        changeEnergy(40);
        changeHunger(10);
        System.out.println(name + " is sleeping... Energy: " + energy);
    }

    // Polymorphic behavior
    public abstract void makeSound();

    public void printStatus() {
        System.out.println("Pet: " + name + " (" + type + ", Age " + age + ")" +
                " | Hunger: " + hunger +
                " | Mood: " + mood +
                " | Energy: " + energy);
    }
}

// -------------------------
// Dog Class
// -------------------------
class Dog extends Pet {
    public Dog(String name, int age) {
        super(name, "Dog", age);
    }

    public Dog(String name) {
        super(name, "Dog");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof Woof!");
    }
}

// -------------------------
// Cat Class
// -------------------------
class Cat extends Pet {
    public Cat(String name, int age) {
        super(name, "Cat", age);
    }

    public Cat(String name) {
        super(name, "Cat");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Meow Meow!");
    }
}

// -------------------------
// Bird Class
// -------------------------
class Bird extends Pet {
    public Bird(String name, int age) {
        super(name, "Bird", age);
    }

    public Bird(String name) {
        super(name, "Bird");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Tweet Tweet!");
    }
}

// -------------------------
// Main Simulation
// -------------------------
public class PetPalApp {
    public static void main(String[] args) {
        // Adopt pets
        Pet dog = new Dog("Buddy", 3);
        Pet cat = new Cat("Whiskers");
        Pet bird = new Bird("Tweety", 2);

        // Print initial status
        System.out.println("------ Initial Status ------");
        dog.printStatus();
        cat.printStatus();
        bird.printStatus();

        System.out.println("\n------ Interactions ------");
        dog.feed();
        cat.play();
        bird.sleep();

        // Make sounds
        System.out.println("\n------ Sounds ------");
        dog.makeSound();
        cat.makeSound();
        bird.makeSound();

        // Final status
        System.out.println("\n------ Final Status ------");
        dog.printStatus();
        cat.printStatus();
        bird.printStatus();
    }
}
