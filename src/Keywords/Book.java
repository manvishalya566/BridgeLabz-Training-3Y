package Keywords;

// Book class
class Book {
    // Static variable shared across all instances
    private static String libraryName;

    // Instance variables
    private String title;
    private String author;
    private final String isbn; // Final variable ensures immutability

    // Constructor to initialize instance variables using 'this'
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Static method to set the library name
    public static void setLibraryName(String name) {
        libraryName = name;
    }

    // Static method to display the library name
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }

    // Getters for instance variables
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getIsbn() {
        return isbn;
    }
}

// Library class with main method
public class Library {
    public static void main(String[] args) {
        // Set the library name (static variable)
        Book.setLibraryName("Egmore Library");

        // Display the library name
        Book.displayLibraryName();

        // Create new book instances
        Book book1 = new Book("Effective Java", "Joshua Bloch", "978-0134685991");
        Book book2 = new Book("Clean Code", "Robert C. Martin", "978-0132350884");

        // Use instanceof before displaying book details
        if (book1 instanceof Book) {
            book1.displayBookDetails();
        }
        System.out.println();
        if (book2 instanceof Book) {
            book2.displayBookDetails();
        }
    }
}

