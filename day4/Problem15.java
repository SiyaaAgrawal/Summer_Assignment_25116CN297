import java.util.Scanner;
public class Problem15{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        int n=sc.nextInt();
        int count=0;
        while(n!=0){
            count++;
            n=n/10;
        }
        System.out.println("The number of digits in the number is: " + count);
        int sum=0;
        int temp=n;
        while(temp!=0){
            int remainder=temp%10;
            sum+=Math.pow(remainder, count);
            temp=temp/10;
        }
        System.out.println("The sum of the powers is: " + sum);
            if(sum==n){
                System.out.println("The number is an Armstrong number.");
            } else {
                System.out.println("The number is not an Armstrong number.");
            }
    }
}
