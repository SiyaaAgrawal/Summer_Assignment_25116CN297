import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class Problem115{

    public static void main(String[] args) {
        // Initialize Scanner for reading terminal entries
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("=========================================");
        System.out.println("      WELCOME TO JAVA CLI MINI-OS       ");
        System.out.println("=========================================");

        // Keep running the OS menu until the user explicitly chooses to exit
        do {
            // 1. Render the main system interaction menu
            System.out.println("\n*** SYSTEM MAIN MENU ***");
            System.out.println("1. System Metrics (Time & Environment)");
            System.out.println("2. File Explorer (List files in current directory)");
            System.out.println("3. Memory Performance Status");
            System.out.println("4. Exit OS");
            System.out.print("Enter your choice (1-4): ");

            // Check if input is a valid integer to prevent crash exceptions
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer line newline character
            } else {
                System.out.println("Error: Please input a numeric digit value.");
                scanner.nextLine(); // Clear invalid junk input
                choice = 0; // Reset choice to repeat loop
                continue;
            }

            // 2. Direct system execution via switch-case selection
            switch (choice) {
                case 1:
                    displaySystemMetrics();
                    break;
                case 2:
                    exploreCurrentDirectory();
                    break;
                case 3:
                    checkMemoryPerformance();
                    break;
                case 4:
                    System.out.println("Shutting down Mini-OS kernel... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option! Please select a valid number from 1 to 4.");
                    break;
            }
            
            // Visual separator for consecutive operations
            if (choice != 4) {
                System.out.println("-----------------------------------------");
            }

        } while (choice != 4);

        // Always close resource leaks upon application termination
        scanner.close();
    }

    /**
     * Option 1: Displays current operating system environment details and time
     */
    private static void displaySystemMetrics() {
        System.out.println("\n[SYSTEM METRICS]");
        System.out.println("Current Date/Time: " + new Date());
        System.out.println("Host OS Architecture: " + System.getProperty("os.arch"));
        System.out.println("Host Operating System: " + System.getProperty("os.name"));
        System.out.println("Java Version Runtime: " + System.getProperty("java.version"));
    }

    /**
     * Option 2: Simulates basic file-system shell utility (like 'ls' or 'dir')
     */
    private static void exploreCurrentDirectory() {
        System.out.println("\n[FILE EXPLORER]");
        File currentDir = new File(".");
        System.out.println("Exploring directory path: " + currentDir.getAbsolutePath());
        
        String[] filesList = currentDir.list();
        if (filesList != null && filesList.length > 0) {
            System.out.println("Files and Folders Found:");
            for (String item : filesList) {
                System.out.println(" -> " + item);
            }
        } else {
            System.out.println("No visible directories or subfiles found in target context.");
        }
    }

    /**
     * Option 3: Inspects JVM heap memory footprints mapping tool performance
     */
    private static void checkMemoryPerformance() {
        System.out.println("\n[MEMORY PERFORMANCE STATUS]");
        Runtime runtime = Runtime.getRuntime();
        
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        
        // Output conversion using Megabyte metrics calculations
        int mbConversionFactor = 1024 * 1024;
        System.out.println("Allocated JVM Heap Memory: " + (totalMemory / mbConversionFactor) + " MB");
        System.out.println("Unallocated Free Memory:   " + (freeMemory / mbConversionFactor) + " MB");
        System.out.println("Actively Used OS Memory:   " + (usedMemory / mbConversionFactor) + " MB");
    }
}

