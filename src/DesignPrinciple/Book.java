package DesignPrinciple;

import java.util.ArrayList;

// Book Class
class Book {
    private String title;
    private String author;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Display book info
    @Override
    public String toString() {
        return "\"" + title + "\" by " + author;
    }
}

// Library Class (Aggregation)
class Library {
    private String name;
    private ArrayList<Book> books; // Aggregation relationship

    // Constructor
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Add a book
    public void addBook(Book book) {
        books.add(book);
    }

    // Show all books
    public void showBooks() {
        System.out.println("Library: " + name);
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book b : books) {
                System.out.println(" - " + b);
            }
        }
        System.out.println();
    }
}

// Main Class
class Main {
    public static void main(String[] args) {
        // Create independent books
        Book b1 = new Book("1984", "George Orwell");
        Book b2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book b3 = new Book("The Great Gatsby", "F. Scott Fitzgerald");

        // Create libraries
        Library cityLibrary = new Library("City Library");
        Library universityLibrary = new Library("University Library");

        // Add books to City Library
        cityLibrary.addBook(b1);
        cityLibrary.addBook(b2);

        // Add books to University Library
        universityLibrary.addBook(b2); // same book can exist in multiple libraries
        universityLibrary.addBook(b3);

        // Display library contents
        cityLibrary.showBooks();
        universityLibrary.showBooks();
    }
}

