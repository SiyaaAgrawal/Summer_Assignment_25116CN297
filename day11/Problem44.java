import java.util.Scanner;
public class Problem44 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number:");
        int n=sc.nextInt();
        int result=factorial(n);
        System.out.print("The factorial is"+ result);

    }
    public static int factorial(int n){
        int product=1;
        for(int i=1;i<=n;i++){
            product=product*i;
        }
        return product;
    }
    
}
