import java.util.Scanner;
public class Problem28{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number:");
        int n=sc.nextInt();
        int reversed=reverseNumber(n);
        System.out.println("Reversed number of"+n+"is:"+reversed);
        

    }
    public static int reverseNumber(int n){
        int reversed=0;
        while(n!=0){
            int digit=n%10;
            reversed=reversed*10+digit;
            n/=10;
        }
        return reversed;
    }
}
