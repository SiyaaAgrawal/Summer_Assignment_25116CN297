import java.util.Scanner;
public class LcmofTwoNumber {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first num:");
        int a =sc.nextInt();
        System.out.println("Enter second num:");
        int b=sc.nextInt();
        int lcm =Math.max(a,b);
        while (true) {
            if(lcm % a==0 && lcm % b==0) {
                System.out.println("LCM of " + a + " and " + b + " is: " + lcm);
                break;
            }
            lcm++;
        }



    }
    
}
