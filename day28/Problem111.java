import java.util.*;
class Seat {
    private final int row;
    private final int col;
    private boolean isBooked;

    public Seat(int row, int col) {
        this.row = row;
        this.col = col;
        this.isBooked = false;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }
    public boolean isBooked() { return isBooked; }
    
    public void book() { this.isBooked = true; }
    public void cancel() { this.isBooked = false; }
}

// Represents a Movie with its own dedicated seating layout
class Movie {
    private final String title;
    private final double price;
    private final Seat[][] seats;
    private final int rows;
    private final int cols;

    public Movie(String title, double price, int rows, int cols) {
        this.title = title;
        this.price = price;
        this.rows = rows;
        this.cols = cols;
        this.seats = new Seat[rows][cols];
        initializeSeats();
    }

    private void initializeSeats() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seats[i][j] = new Seat(i + 1, j + 1);
            }
        }
    }

    public String getTitle() { return title; }
    public double getPrice() { return price; }

    // Displays available (O) and booked (X) seats
    public void displaySeatingChart() {
        System.out.println("\n--- Seating Chart for: " + title + " ---");
        System.out.print("      ");
        for (int j = 0; j < cols; j++) {
            System.out.printf("Col %-3d", j + 1);
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.printf("Row %-2d [ ", i + 1);
            for (int j = 0; j < cols; j++) {
                char status = seats[i][j].isBooked() ? 'X' : 'O';
                System.out.print(status + "      ");
            }
            System.out.println("]");
        }
        System.out.println("Legend: [ O = Available ]  [ X = Booked ]");
    }

    // Main logic to reserve a seat safely
    public boolean reserveSeat(int row, int col) {
        if (row < 1 || row > rows || col < 1 || col > cols) {
            System.out.println("❌ Error: Invalid row or column entered.");
            return false;
        }
        Seat selectedSeat = seats[row - 1][col - 1];
        if (selectedSeat.isBooked()) {
            System.out.println("❌ Error: Seat is already taken.");
            return false;
        }
        selectedSeat.book();
        return true;
    }
}

// Main Driver Application
public class Problem111{
    private static final List<Movie> movies = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize sample movies (Title, Ticket Price, Rows, Columns)
        movies.add(new Movie("Inception", 12.50, 5, 6));
        movies.add(new Movie("Interstellar", 15.00, 6, 8));
        movies.add(new Movie("The Dark Knight", 10.00, 4, 6));

        System.out.println("==========================================");
        System.out.println("🎟️  Welcome to the Java Ticket Booking System 🎟️");
        System.out.println("==========================================");

        while (true) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. View Movies & Book Tickets");
            System.out.println("2. Exit Application");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    handleBookingWorkflow();
                    break;
                case "2":
                    System.out.println("Thank you for using the Ticket Booking System. Goodbye!");
                    return;
                default:
                    System.out.println("❌ Invalid selection. Please choose 1 or 2.");
            }
        }
    }

    private static void handleBookingWorkflow() {
        System.out.println("\n--- Available Movies ---");
        for (int i = 0; i < movies.size(); i++) {
            Movie m = movies.get(i);
            System.out.printf("%d. %s ($%.2f)\n", i + 1, m.getTitle(), m.getPrice());
        }
        System.out.print("Select a movie number: ");
        
        int movieIdx;
        try {
            movieIdx = Integer.parseInt(scanner.nextLine().trim()) - 1;
            if (movieIdx < 0 || movieIdx >= movies.size()) {
                System.out.println("❌ Invalid movie index selection.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Input must be a valid number.");
            return;
        }

        Movie selectedMovie = movies.get(movieIdx);
        selectedMovie.displaySeatingChart();

        // Get seat coordinates from user
        try {
            System.out.print("\nEnter Row Number to book: ");
            int row = Integer.parseInt(scanner.nextLine().trim());
            
            System.out.print("Enter Column Number to book: ");
            int col = Integer.parseInt(scanner.nextLine().trim());

            // Process booking transaction
            if (selectedMovie.reserveSeat(row, col)) {
                System.out.println("\n🎉 SUCCESS!");
                System.out.printf("Successfully booked ticket for: %s\n", selectedMovie.getTitle());
                System.out.printf("Seat Location: Row %d, Column %d\n", row, col);
                System.out.printf("Total Amount Billed: $%.2f\n", selectedMovie.getPrice());
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Processing failed: Row and column must be integers.");
        }
    }
}

