import java.util.Scanner;
public class SumofNaturalNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of terms:");
        int n = sc.nextInt();
        int sum = 0;
        for(int i=1; i<=n; i++){
            sum += i;
        }
        System.out.println("The sum of first " + n + " numbers is: " + sum);
    }
}
