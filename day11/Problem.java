import java.util.Scanner;
public class Problem{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number:");
        int n=sc.nextInt();
        if(isPrime(n)){
            System.out.print(n+"is aPrime number");
        }
        else{
        System.out.print(n+"is not a Prime number");
        }
        sc.close();
    }
        
    public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        if(n<=3){
            return true;
        }
        if(n%2==0||n%3==0){
            return false;
        }
            
    }
}