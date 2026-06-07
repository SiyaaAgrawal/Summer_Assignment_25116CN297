import java.util.Scanner;
public class Problem25{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number:");
        int num=sc.nextInt();
        long factorial=calculateFactorial(num);
        System.out.println("Factorial of " + num + " is: " + factorial);
    }

    public static long calculateFactorial(int n){
        if(n==0) return 1;
        else return n*calculateFactorial(n-1);
    }
}