import java.util.Scanner;
public class Problem46 {
    public static boolean isArmstrong(int n){
        if(n<0){
            return false;
        }
        int originalNum=n;
        int sum=0;
        int digits=(n==0) ? 1: (int) Math.log10(n)+1;
        while(n>0){
            int rem=n%10;
            sum+= Math.pow(rem,digits);
            n/=10;
        }
        return sum==originalNum;

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number:");
        int n=sc.nextInt();
        if(isArmstrong(n)){
            System.out.println(n+"is an Armstrong.");
        }
        else{
            System.out.println(n+"is not a Armstrong.");
        }


    }
    
}
