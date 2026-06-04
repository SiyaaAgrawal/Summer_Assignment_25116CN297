import java.util.Scanner;
public class Problem16{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the lower bound: ");
        int lower = scanner.nextInt();
        System.out.print("Enter the upper bound: ");
        int upper = scanner.nextInt();

        System.out.println("Armstrong numbers between " + lower + " and " + upper + " are:");
        for (int i = lower; i <= upper; i++) {
            if (isArmstrong(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isArmstrong(int n) {
        int original = n;
        int sum = 0;
        int count = 0;
        int temp = n;

        // Count the number of digits
        while (temp != 0) {
            count++;
            temp /= 10;
        }

        // Calculate the sum of each digit raised to the power of the number of digits
        temp = n;
        while (temp != 0) {
            int remainder = temp % 10;
            sum += Math.pow(remainder, count);
            temp /= 10;
        }

        return sum == original;
    }
}