import java.util.*;
// Class representing an individual contact entity
class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    // Constructor to initialize contact fields
    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters and Setters for maintaining encapsulation
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Name: " + name + " | Phone: " + phoneNumber + " | Email: " + email;
    }
}

// Main Driver Class handling the application logic and User Interface
public class Problem112{
    private static ArrayList<Contact> contactList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        // Keep executing a menu-driven interface until the user terminates
        do {
            System.out.println("\n--- CONTACT MANAGEMENT SYSTEM ---");
            System.out.println("1. Add New Contact");
            System.out.println("2. Display All Contacts");
            System.out.println("3. Search Contact by Name");
            System.out.println("4. Update Contact Details");
            System.out.println("5. Delete a Contact");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear input buffer

            switch (choice) {
                case 1 -> addContact();
                case 2 -> displayContacts();
                case 3 -> searchContact();
                case 4 -> updateContact();
                case 5 -> deleteContact();
                case 6 -> System.out.println("Exiting application. Goodbye!");
                default -> System.out.println("Invalid selection. Try again.");
            }
        } while (choice != 6);
    }

    // 1. CREATE: Add a fresh contact record
    private static void addContact() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine().trim();
        System.out.print("Enter Email Address: ");
        String email = scanner.nextLine().trim();

        if (name.isEmpty() || phone.isEmpty()) {
            System.out.println("Error: Name and Phone Number cannot be blank!");
            return;
        }
        contactList.add(new Contact(name, phone, email));
        System.out.println("Contact added successfully!");
    }

    // 2. READ: Display entire contact directory
    private static void displayContacts() {
        if (contactList.isEmpty()) {
            System.out.println("Your contact directory is currently empty.");
            return;
        }
        System.out.println("\n--- Saved Contacts ---");
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println((i + 1) + ". " + contactList.get(i));
        }
    }

    // 3. READ: Query contact instances by exact name string
    private static void searchContact() {
        System.out.print("Enter the name to search: ");
        String query = scanner.nextLine().trim();
        boolean found = false;

        for (Contact contact : contactList) {
            if (contact.getName().equalsIgnoreCase(query)) {
                System.out.println("Match Found -> " + contact);
                found = true;
            }
        }
        if (!found) System.out.println("No matching contact found with that name.");
    }

    // 4. UPDATE: Modify properties of an existing contact record
    private static void updateContact() {
        System.out.print("Enter the exact name of the contact to update: ");
        String query = scanner.nextLine().trim();
        Contact contactToUpdate = null;

        for (Contact contact : contactList) {
            if (contact.getName().equalsIgnoreCase(query)) {
                contactToUpdate = contact;
                break;
            }
        }

        if (contactToUpdate == null) {
            System.out.println("Contact matching '" + query + "' not found.");
            return;
        }

        System.out.print("Enter New Name (or press Enter to skip): ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) contactToUpdate.setName(newName);

        System.out.print("Enter New Phone Number (or press Enter to skip): ");
        String newPhone = scanner.nextLine().trim();
        if (!newPhone.isEmpty()) contactToUpdate.setPhoneNumber(newPhone);

        System.out.print("Enter New Email (or press Enter to skip): ");
        String newEmail = scanner.nextLine().trim();
        if (!newEmail.isEmpty()) contactToUpdate.setEmail(newEmail);

        System.out.println("Contact profile modified successfully!");
    }

    // 5. DELETE: Purge a specific contact object from memory
    private static void deleteContact() {
        System.out.print("Enter the exact name of the contact to delete: ");
        String query = scanner.nextLine().trim();
        Contact contactToRemove = null;

        for (Contact contact : contactList) {
            if (contact.getName().equalsIgnoreCase(query)) {
                contactToRemove = contact;
                break;
            }
        }

        if (contactToRemove != null) {
            contactList.remove(contactToRemove);
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("No match found. Complete removal aborted.");
        }
    }
}

