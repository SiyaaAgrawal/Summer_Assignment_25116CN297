import java.util.*;
public class Problem102 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the age:");
        int n=sc.nextInt();
        if(n<18){
            System.out.println("You are not elligible for voting.");
        }
        else{
            System.out.println("You are elligible for voting.");
        }
    }    
}
