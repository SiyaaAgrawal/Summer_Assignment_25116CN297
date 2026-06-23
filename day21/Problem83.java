import java.util.*;
public class Problem83 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the string:");
        String a=sc.nextLine();
        int vowels=0;
        int consonants=0;
        a=a.toLowerCase();
        for(int i=0;i<a.length();i++){
            char ch=a.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                vowels++;
            }
            else if( ch>='a'&& ch<='z'){
                consonants++;
            }
        }
        System.out.println("No. of vowels:"+vowels);
        System.out.println("No. of consonants:"+consonants);
        
    }
    
}
