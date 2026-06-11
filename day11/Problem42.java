import java.util.Scanner;
public class Problem42 {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter first number:");
        int a=sc.nextInt();
        System.out.print("Enter second number:");
        int b=sc.nextInt();
        int result=num(a,b);
        System.out.print("The result is:"+result);

    }
    public static int num(int a, int b) {
        if(a>b){
            return(a);
        }
        else{
            return(b);
        }

    }
    
}
