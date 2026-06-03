import java.util.Scanner;
public class CheckingPrime {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        int num=sc.nextInt();
        for(int i=2;i<=num-1;i++){
            if(num %i!=0){
                System.out.println(num+" "+"is a prime number");
                break;
            }
        }
    }
    
}
