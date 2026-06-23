import java.util.*;
public class Problem82 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("The original string is:");
        String a=sc.nextLine();
        String reverse="";
        for(int i=a.length()-1;i>=0;i--){
            reverse+=a.charAt(i);
        }
        System.out.println("Original:"+a);
        System.out.println("Reversed:"+reverse);
    }
    
}
