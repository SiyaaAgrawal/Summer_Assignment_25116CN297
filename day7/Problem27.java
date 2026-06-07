import java.util.Scanner;

public class Problem27{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number:");
        int n=sc.nextInt();
        int sum=calculateSumofDigit(n);
        System.out.println("Sum of digits of"+n+"is:"+sum);
    }
    public static int calculateSumofDigit(int n){
        if(n==0){
            return 0;
        }
        return (n%10) + calculateSumofDigit(n/10);
    }
}
