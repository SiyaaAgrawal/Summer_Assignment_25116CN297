import java.util.Scanner;
public class Problem48 {
    public static boolean isPerfect(int n){
        if(n<=1){
            return false;
        }
        int sum=1;
        int squareRoot=(int)Math.sqrt(n);
        for(int i=2;i<=squareRoot;i++){
            if(n%i==0){
                sum+=i;
                int b=n/i;
                if(i!=b){
                    sum+=b;
                }
            }
        }
        return sum==n;

    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number:");
        int n=sc.nextInt();
        if(isPerfect(n)){
            System.out.println(n+"is a perfect number.");
        } else{
            System.out.print(n+"is not a perfect number.");
        }
    }
    
}
