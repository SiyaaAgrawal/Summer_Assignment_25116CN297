import java.util.*;
public class Problem96{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string:");
        String a=sc.nextLine();
        String word[]=a.split(" ");
        for(int i=0;i<word.length;i++){
            if(word[i].equals("")){
                continue;
            }
            for(int j=i+1;j<word.length;j++){
                if(word[i].equalsIgnoreCase(word[j])){
                    word[j]=" ";
                }
            }
        }
        StringBuilder result=new StringBuilder();
        for(String words:word){
            if(!words.equals("")){
                result.append(words).append(" ");
            }
        }
        System.out.println("Original String:"+ a);
        System.err.println("After removing duplicates:"+result.toString().trim());
    }
}
