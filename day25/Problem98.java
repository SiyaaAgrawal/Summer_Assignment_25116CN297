import java.util.*;
public class Problem98{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter string:");
        String a=sc.nextLine();
        System.out.print("Enter string2:");
        String b=sc.nextLine();
        boolean presentInStr[]=new boolean[26];
        boolean common[]=new boolean[26];
        for(int i=0;i<a.length();i++){
            presentInStr[a.charAt(i)-'a']=true;

        }
        for(int i=0;i<b.length();i++){
            int index=b.charAt(i)-'a';
            if(presentInStr[index]){
                common[index]=true;
            }
        }
        System.out.print("Common characters:");
        for(int i=0;i<26;i++){
            if(common[i]){
                System.out.print((char)(i+'a')+" ");
            }
        }

    }
}
