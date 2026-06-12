import java.util.Scanner;
public class Problem45{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number:");
        int n=sc.nextInt();
        int reverse=0;
        int rem=0;
        int temp=0;
        if(getReverse(n,reverse)==n){
            System.out.println(n+"is Palindrome.");

        }
        else{
            System.out.println(n+"is not a Palindrome.");
        }
    }
        public static int getReverse(int n,int rev){
            if(n==0){
                return rev;

            }
            int rem=n%10;
            rev=rev*10+rem;
            return getReverse(n/10,rev);
        }
}