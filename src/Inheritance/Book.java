package Inheritance;

// Superclass Book
class Book {
    String title;
    int publicationYear;

    // Constructor
    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    // Method to display book info
    void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// Subclass Author
class Author extends Book {
    String name;
    String bio;

    // Constructor
    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    // Overriding displayInfo
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Bio: " + bio);
        System.out.println("----------------------");
    }
}

// Demo class
class LibraryDemo {
    public static void main(String[] args) {
        // Create Author object (with Book details)
        Author author1 = new Author("Java Programming", 2020, "James Gosling", "Creator of Java");
        Author author2 = new Author("Data Structures", 2019, "Robert Lafore", "Expert in computer science education");

        // Display book and author details
        author1.displayInfo();
        author2.displayInfo();
    }
}

