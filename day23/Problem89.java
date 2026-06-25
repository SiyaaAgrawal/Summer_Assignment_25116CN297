import java.util.*;
public class Problem89{
    public static char firstNonRepeating(String a){
        int charCounts[]= new int[256];
        for(int i=0;i<a.length();i++){
            charCounts[a.charAt(i)]++;
        }
        for(int i=0;i<a.length();i++){
            if(charCounts[a.charAt(i)]==1){
                return a.charAt(i);
            }
        }
        return '\0';
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the string:");
        String a=sc.nextLine();
        char result=firstNonRepeating(a);
        System.out.println("First non repeating character:"+result);

    }
}