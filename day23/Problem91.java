import java.util.*;
public class Problem91{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the str1:");
        String a=sc.nextLine();
        System.out.print("Enter the string2:");
        String b=sc.nextLine();
        a=a.toLowerCase();
        b=b.toLowerCase();
        if(a.length()==b.length()){
            char arr1[]=a.toCharArray();
            char arr2[]=b.toCharArray();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            boolean result=Arrays.equals(arr1,arr2);
            if(result){
                System.out.println(a+"and"+b+"are anagram.");
            }else{
                System.out.println(a+"and"+b+"are not anagram.");
            }
        }else{
            System.out.println(a+"and"+b+"are not anagram.");
        }
    }
}
