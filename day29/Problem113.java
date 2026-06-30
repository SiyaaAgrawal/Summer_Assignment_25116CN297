import java.util.*;
public class Problem113{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double num1, num2, result;

        do {
            System.out.println("\n=== MENU DRIVEN CALCULATOR ===");
            System.out.println("1. Addition (+)\n2. Subtraction (-)\n3. Multiplication (*)\n4. Division (/)\n5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();

            if (choice == 5) break;

            if (choice < 1 || choice > 5) {
                System.out.println("Error: Invalid choice!");
                continue;
            }

            System.out.print("Enter first number: ");
            num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            num2 = scanner.nextDouble();

            switch (choice) {
                case 1: result = num1 + num2; System.out.printf("Result: %.2f\n", result); break;
                case 2: result = num1 - num2; System.out.printf("Result: %.2f\n", result); break;
                case 3: result = num1 * num2; System.out.printf("Result: %.2f\n", result); break;
                case 4:
                    if (num2 == 0) System.out.println("Error: Division by zero!");
                    else System.out.printf("Result: %.2f\n", num1 / num2);
                    break;
            }
        } while (choice != 5);
        scanner.close();
    }
}
