import java.util.Scanner;
public class Problem21 {
    public static void main(String args[]){
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter a decimal number:");
        int n=sc.nextInt();
        String binary="";
        while(n>0){
            int remainder=n%2;
            binary=remainder+binary;
            n/=2;
        }
        System.out.println("Binary equivalent: "+binary);
    }
    
}
