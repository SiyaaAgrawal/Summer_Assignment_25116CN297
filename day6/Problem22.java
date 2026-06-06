import java.util.Scanner;
public class Problem22{
    public static void main(String args[]){
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter a binary number:");
        int n=sc.nextInt();
        int decimal=0;
        int power=0;
        while(n>0){
            int lastDigit=n%10;
            decimal+=lastDigit*Math.pow(2,power);
            power++;
            n/=10;
        }
        System.out.println("Decimal equivalent: "+decimal);
    }
}
