import java.util.*;
public class Problem94 {
    public static String compress(String a){
        if(a==null||a.length()<=1){
            return a;
        }
        StringBuilder compressed=new StringBuilder();
        int count=1;
        for(int i=0;i<a.length();i++){
            if(i+1<a.length()&&a.charAt(i)==a.charAt(i+1)){
                count++;
            }else{
                compressed.append(a.charAt(i));
                compressed.append(count);
                count=1;
            }
        }
        return compressed.length()<a.length()?compressed.toString():a;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner (System.in);
        System.out.print("Enter the string1:");
        String a=sc.nextLine();
       // System.out.println("Enter the string2:");
        //String b=sc.nextLine();
        System.out.println("Original:"+a+"  ,Compressed:"+compress(a));
       // System.out.println("Original:"+b+"  ,Compressed:"+compress(b));
    }
}
