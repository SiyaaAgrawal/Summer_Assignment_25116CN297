import java.util.*;
public class Problem90 {
    public static char firstRepeating(String str){
        boolean a[]=new boolean[256];
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(a[ch]){
                return ch;
            }
            a[ch]=true;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the string:");
        String str=sc.nextLine();
        System.out.println("Enter the string:"+firstRepeating(str));
    }  
}
