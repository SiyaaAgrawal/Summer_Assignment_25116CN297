import java.util.*;
public class Problem92{
    public static void main(String[] arg){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string:");
        String a =sc.nextLine();
        int charFreq[]=new int[256];
        for(int i=0;i<a.length();i++){
            charFreq[a.charAt(i)]++;
        }
        int maxCount=-1;
        int maxChar=' ';
        for(int i=0;i<a.length();i++){
            char ch=a.charAt(i);
            if(charFreq[ch]>maxCount){
                maxCount=charFreq[ch];
                maxChar=ch;
            }
        }
        System.out.println("Original String:"+a);
        System.out.println("Maximium occurring character"+maxChar+" ");
        System.out.println("total occurrences:"+maxCount);
    }
}
