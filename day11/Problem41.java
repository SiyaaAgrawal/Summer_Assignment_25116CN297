import java.util.Scanner;
public class Problem41{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter first number:");
        int a=sc.nextInt();
        System.out.print("Enter second number");
        int b=sc.nextInt();
        int result=num(a ,b);
        System.out.println("The total is :"+result);

    }
    public static int num(int a,int b){
        int sum=a +b;
        return sum;
    }
}