import java.util.Scanner;
public class Problem18{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        int n=sc.nextInt();
        int sum=0;
        int temp=n;
        while(temp>0){
            int digit=temp%10;
            int factorial=1;
            for(int i=1;i<=digit;i++){
                factorial*=i;
            }
            sum+=factorial;
            temp/=10;
        }
        if(sum==n){
            System.out.println("The number is a strong number.");
        }else{
            System.out.println("The number is not a strong number.");
        }
    }
    
}
