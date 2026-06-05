import java.util.Scanner;
public class Problem20{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        int n=sc.nextInt();
        System.out.println("The largest prime factor of the number is:");
        // Implementation for finding the largest prime factor would go 
        // here
        int largestPrimeFactor = 1;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                largestPrimeFactor = i;
                n /= i;
            }
        }
        System.out.println(largestPrimeFactor);
    }
}
