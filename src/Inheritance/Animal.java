package Inheritance;
// Superclass
class Animal {
    String name;
    int age;

    // Constructor
    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to be overridden
    void makeSound() {
        System.out.println("Animal makes a sound.");
    }

    // Method to display info
    void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Subclass Dog
class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " (Dog) says: Woof Woof!");
    }
}

// Subclass Cat
class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " (Cat) says: Meow Meow!");
    }
}

// Subclass Bird
class Bird extends Animal {
    Bird(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " (Bird) says: Tweet Tweet!");
    }
}

// Demo Class
class AnimalHierarchyDemo {
    public static void main(String[] args) {
        // Creating objects of subclasses
        Animal dog = new Dog("Buddy", 3);
        Animal cat = new Cat("Whiskers", 2);
        Animal bird = new Bird("Tweety", 1);

        // Storing in an array to show polymorphism
        Animal[] animals = { dog, cat, bird };

        for (Animal a : animals) {
            a.displayInfo();
            a.makeSound();
            System.out.println("-----------------");
        }
    }
}
