package Inheritance;

// Base class Order
class Order {
    int orderId;
    String orderDate;

    // Constructor
    Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    // Method to get status
    String getOrderStatus() {
        return "Order placed on " + orderDate;
    }
}

// Subclass ShippedOrder
class ShippedOrder extends Order {
    String trackingNumber;

    // Constructor
    ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus() {
        return "Order shipped with Tracking No: " + trackingNumber;
    }
}

// Subclass DeliveredOrder
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    // Constructor
    DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return "Order delivered on " + deliveryDate;
    }
}

// Demo Class
class OrderManagementDemo {
    public static void main(String[] args) {
        // Base class object
        Order order = new Order(101, "2025-09-10");

        // Shipped order object
        ShippedOrder shipped = new ShippedOrder(102, "2025-09-08", "TRK12345");

        // Delivered order object
        DeliveredOrder delivered = new DeliveredOrder(103, "2025-09-05", "TRK67890", "2025-09-09");

        // Polymorphism: store all in an array
        Order[] orders = { order, shipped, delivered };

        // Display statuses
        for (Order o : orders) {
            System.out.println("Order ID: " + o.orderId);
            System.out.println(o.getOrderStatus());
            System.out.println("----------------------");
        }
    }
}

