package Constructor;

class Circle {
    double radius;

    // Default constructor
    Circle() {
        this(1.0);  // Calls parameterized constructor with default value
    }

    // Parameterized constructor
    Circle(double radius) {
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }
}
