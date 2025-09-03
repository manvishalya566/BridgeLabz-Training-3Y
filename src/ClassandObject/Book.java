package ClassandObject;

public class Book {
    // Instance variables
    private String title;
    private String author;
    private double price;

    // Constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("📖 Title   : " + title);
        System.out.println("✍️ Author  : " + author);
        System.out.println("💰 Price   : ₹" + price);
        System.out.println("---------------------------");
    }

    // Main method
    public static void main(String[] args) {
        Book book1 = new Book("2 States", "Chetan Bhagat", 500);
        Book book2 = new Book("Wings of Fire", "A.P.J. Abdul Kalam", 500);

        book1.displayDetails();
        book2.displayDetails();
    }
}
