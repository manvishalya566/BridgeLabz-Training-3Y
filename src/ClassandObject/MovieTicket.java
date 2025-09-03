package ClassandObject;

public class MovieTicket {
    // Attributes
    private String movieName;
    private String seatNumber;
    private double price;
    private boolean isBooked;

    // Constructor
    public MovieTicket(String movieName) {
        this.movieName = movieName;
        this.seatNumber = "Not Assigned";
        this.price = 0.0;
        this.isBooked = false;
    }

    // Method to book a ticket
    public void bookTicket(String seatNumber, double price) {
        if (isBooked) {
            System.err.println("❌ House full! Ticket already booked.");
        } else {
            this.seatNumber = seatNumber;
            this.price = price;
            this.isBooked = true;
            System.out.println("🎟️ Ticket successfully booked!");
            displayTicket();
        }
    }

    // Method to display ticket details
    public void displayTicket() {
        if (isBooked) {
            System.out.println("🎬 Movie       : " + movieName);
            System.out.println("🪑 Seat Number : " + seatNumber);
            System.out.println("💰 Price       : $" + price);
            System.out.println("------------------------------");
        } else {
            System.out.println("⚠️ Ticket not booked yet.");
        }
    }

    // Main method
    public static void main(String[] args) {
        MovieTicket ticket1 = new MovieTicket("Dragon");

        ticket1.displayTicket();                  // Not booked yet
        ticket1.bookTicket("A10", 120.0);         // First booking
        ticket1.bookTicket("B10", 120.0);         // Attempt to rebook
        ticket1.displayTicket();                  // Final ticket details
    }
}

