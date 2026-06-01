public class CountDigitinNumber {
   public static void main(String[] args) {
    java.util.Scanner sc = new java.util.Scanner(System.in);
    System.out.print("Enter a number: ");
    int n = sc.nextInt();
    int count = 0;
    while (n != 0) {
        n /= 10; // Remove the last digit
        count++; // Increment the count of digits
    }
    System.out.println("The number of digits in the given number is: " + count);
    sc.close();
   } 
}
