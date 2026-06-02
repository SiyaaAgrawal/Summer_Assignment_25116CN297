import java.util.Scanner;
public class ProductofDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = sc.nextInt();
        int product = 1; // Initialize product to 1

        while (num > 0) {
            int digit = num % 10; // Get the last digit
            product *= digit; // Multiply the digit to the product
            num /= 10; // Remove the last digit
        }

        System.out.println("Product of the digits: " + product);
    }
    
}
