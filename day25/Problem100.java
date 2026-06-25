import java.util.*;
public class Problem100 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("enter a sentence:");
        String input=sc.nextLine();
        String words[]=input.split(" ");
        Arrays.sort(words,(word1,word2)->Integer.compare(word1.length(),word2.length()));
        System.out.println("Words sorted from shortest o longest:");
        for(String word:words){
            System.out.println(word+" ");
        }
    }
}
