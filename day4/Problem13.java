import java.util.Scanner;
public class Problem13{
    public static void main (String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number till which we want fibonacci series");
        int n=sc.nextInt();
        int a=0, b=1;
        while(a<=n){
            System.out.print(a+" ");
            int temp=a;
            a=b;
            b=temp+b;
        }
    }
}
