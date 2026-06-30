// InventoryManager.java
import java.util.ArrayList;
import java.util.Scanner;

public class Problem116{
    private final ArrayList<Product> inventory = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Problem116().runMenu();
    }

    public void runMenu() {
        while (true) {
            System.out.println("\n1. Add | 2. Update | 3. List | 4. Low Stock | 5. Exit");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> addProduct();
                case "2" -> updateStock();
                case "3" -> displayInventory();
                case "4" -> checkLowStock();
                case "5" -> { return; }
            }
        }
    }

    private void addProduct() {
        // Implementation for gathering input and adding Product to list
    }

    private void updateStock() {
        // Implementation for finding product and updating quantity
    }

    private void displayInventory() {
        inventory.forEach(System.out::println);
    }

    private void checkLowStock() {
        // Implementation to filter products below threshold
    }
}
// Product.java
class Product {
    private String id;
    private String name;
    private int quantity;
    private double price;

    public Product(String id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Standard Getters, Setters, and toString()
    public String getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Qty: %d | Price: $%.2f", id, name, quantity, price);
    }
}

