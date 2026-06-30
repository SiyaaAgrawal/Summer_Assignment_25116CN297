import java.util.ArrayList;
import java.util.Scanner;

// Model class representing an individual book
class Book {
    private String id;
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false; // New books are available by default
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isBorrowed() { return isBorrowed; }

    public void setBorrowed(boolean borrowed) { this.isBorrowed = borrowed; }

    @Override
    public String toString() {
        String status = isBorrowed ? "Borrowed" : "Available";
        return "[" + id + "] Title: " + title + " | Author: " + author + " | Status: " + status;
    }
}

// Controller and Main Menu Management class
public class Problem118{
    private ArrayList<Book> inventory = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Problem118 library = new Problem118();
        library.runMenu();
    }

    // Handles the primary interactive terminal loop
    public void runMenu() {
        while (true) {
            System.out.println("\n===== MINI LIBRARY SYSTEM =====");
            System.out.println("1. Add a Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Borrow a Book");
            System.out.println("5. Return a Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1": addBook(); break;
                case "2": displayBooks(); break;
                case "3": searchBook(); break;
                case "4": borrowBook(); break;
                case "5": returnBook(); break;
                case "6": 
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default: 
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        }
    }

    // 1. Adds a unique book to the arraylist
    private void addBook() {
        System.out.print("Enter unique Book ID: ");
        String id = scanner.nextLine();
        
        // Prevent duplicate IDs
        if (findBookById(id) != null) {
            System.out.println("Error: A book with this ID already exists.");
            return;
        }

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();

        inventory.add(new Book(id, title, author));
        System.out.println("Success: Book registered successfully!");
    }

    // 2. Prints all books matching inventory status
    private void displayBooks() {
        if (inventory.isEmpty()) {
            System.out.println("The library is currently empty.");
            return;
        }
        System.out.println("\n--- Library Inventory ---");
        for (Book book : inventory) {
            System.out.println(book);
        }
    }

    // 3. Filters books by case-insensitive title match
    private void searchBook() {
        System.out.print("Enter title keyword to search: ");
        String query = scanner.nextLine().toLowerCase();
        boolean found = false;

        for (Book book : inventory) {
            if (book.getTitle().toLowerCase().contains(query)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching books found.");
        }
    }

    // 4. Transitions a book status to borrowed
    private void borrowBook() {
        System.out.print("Enter Book ID to borrow: ");
        String id = scanner.nextLine();
        Book book = findBookById(id);

        if (book == null) {
            System.out.println("Error: Book ID not found.");
        } else if (book.isBorrowed()) {
            System.out.println("Sorry, this book is already checked out.");
        } else {
            book.setBorrowed(true);
            System.out.println("Success: You have successfully borrowed: " + book.getTitle());
        }
    }

    // 5. Clears borrowed flag to return book to catalog
    private void returnBook() {
        System.out.print("Enter Book ID to return: ");
        String id = scanner.nextLine();
        Book book = findBookById(id);

        if (book == null) {
            System.out.println("Error: Book ID does not match any entry.");
        } else if (!book.isBorrowed()) {
            System.out.println("This book is already sitting in the library.");
        } else {
            book.setBorrowed(false);
            System.out.println("Success: Handed back into inventory: " + book.getTitle());
        }
    }

    // Helper utility method to locate entries by unique key
    private Book findBookById(String id) {
        for (Book book : inventory) {
            if (book.getId().equalsIgnoreCase(id)) {
                return book;
            }
        }
        return null;
    }
}

