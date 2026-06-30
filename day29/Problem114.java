import java.util.*;
public class Problem114{
    private static int[] array;
    private static int size = 0; // Tracks the actual number of elements active in the array
    private static final int MAX_CAPACITY = 100; // Defines maximum size boundaries
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        array = new int[MAX_CAPACITY];
        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println("   ARRAY OPERATION SYSTEM MENU   ");
            System.out.println("=================================");
            System.out.println("1. Initialize / Reset Array");
            System.out.println("2. Display Array Elements");
            System.out.println("3. Insert Element at Location");
            System.out.println("4. Delete Element from Location");
            System.out.println("5. Search an Element (Linear Search)");
            System.out.println("6. Sort the Array (Bubble Sort)");
            System.out.println("7. Exit System");
            System.out.print("Enter your choice (1-7): ");
            
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    initializeArray(scanner);
                    break;
                case 2:
                    displayArray();
                    break;
                case 3:
                    insertElement(scanner);
                    break;
                case 4:
                    deleteElement(scanner);
                    break;
                case 5:
                    searchElement(scanner);
                    break;
                case 6:
                    sortArray();
                    break;
                case 7:
                    System.out.println("Exiting System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid selection! Please choose an option between 1 and 7.");
            }
        } while (choice != 7);

        scanner.close();
    }

    // 1. Initialize Array
    private static void initializeArray(Scanner sc) {
        System.out.print("Enter the number of initial elements (Max " + MAX_CAPACITY + "): ");
        int n = sc.nextInt();
        if (n < 0 || n > MAX_CAPACITY) {
            System.out.println("Invalid size! Re-initialization aborted.");
            return;
        }
        size = n;
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("Array initialized successfully.");
    }

    // 2. Display Array
    private static void displayArray() {
        if (size == 0) {
            System.out.println("The array is empty!");
            return;
        }
        System.out.print("Current Array Structure: [ ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + (i < size - 1 ? ", " : ""));
        }
        System.out.println(" ]");
    }

    // 3. Insert Element
    private static void insertElement(Scanner sc) {
        if (size >= MAX_CAPACITY) {
            System.out.println("Overflow Error: Array capacity reached.");
            return;
        }
        System.out.print("Enter the index where you want to insert (0 to " + size + "): ");
        int index = sc.nextInt();
        
        if (index < 0 || index > size) {
            System.out.println("Invalid index position.");
            return;
        }
        System.out.print("Enter element value to insert: ");
        int value = sc.nextInt();

        // Shift elements down to make space
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        size++;
        System.out.println("Element inserted successfully.");
    }

    // 4. Delete Element
    private static void deleteElement(Scanner sc) {
        if (size == 0) {
            System.out.println("Underflow Error: No elements to delete.");
            return;
        }
        System.out.print("Enter the index of the element to delete (0 to " + (size - 1) + "): ");
        int index = sc.nextInt();

        if (index < 0 || index >= size) {
            System.out.println("Invalid index position.");
            return;
        }
        int removedValue = array[index];
        // Shift elements up to close the gap
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        System.out.println("Deleted element '" + removedValue + "' from index " + index);
    }

    // 5. Search Element
    private static void searchElement(Scanner sc) {
        if (size == 0) {
            System.out.println("The array is empty. Nothing to search.");
            return;
        }
        System.out.print("Enter target element value to find: ");
        int target = sc.nextInt();
        int foundIndex = -1;

        for (int i = 0; i < size; i++) {
            if (array[i] == target) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            System.out.println("Element found at position index: " + foundIndex);
        } else {
            System.out.println("Element not found in the array.");
        }
    }

    // 6. Sort Array (Bubble Sort)
    private static void sortArray() {
        if (size == 0) {
            System.out.println("Array is empty. No elements to sort.");
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("Array sorted using Bubble Sort in ascending order.");
        displayArray();
    }
}

