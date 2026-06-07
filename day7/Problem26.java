import java.util.Scanner;
public class Problem26{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number:");
        int num=sc.nextInt();
        long fibonacci=calculateFibonacci(num);
        System.out.println("Fibonacci of " + num + " is: " + fibonacci);
    }
    public static long calculateFibonacci(int n){
        if(n<=1){
            return n;
        }
        return calculateFibonacci(n-1) + calculateFibonacci(n-2);
    }
}