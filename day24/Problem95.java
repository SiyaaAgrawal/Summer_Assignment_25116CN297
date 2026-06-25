import java.util.*;
public class Problem95 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the string:");
        String a=sc.nextLine();
        String words[]=a.split(" ");
        String longestword="";
        for(String word: words){
            if(word.length()>longestword.length()){
                longestword=word;
            }
        }
        System.out.print(longestword);
    }
    
}
