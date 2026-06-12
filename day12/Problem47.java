import java.util.Scanner;
public class Problem47 {
    public static int Fibonacci(int n){
        if(n<=1){
            return n;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the num:");
        int n=sc.nextInt();
        System.out.print("Fibonacci num at position"+"is"+Fibonacci(n));

    }

}
    

