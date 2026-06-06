
import java.util.Scanner;
public class Problem23{
    public static void main(String args[]){
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter a number:");
        int n=sc.nextInt();
        int count=0;
        while(n>0){
            if((n&1)==1){
                count++;
            }
            n>>=1;
        }
        System.out.println("Number of set bits: "+count);
    }
}
