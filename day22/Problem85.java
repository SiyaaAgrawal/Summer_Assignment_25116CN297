import java.util.*;
public class Problem85{
    public static boolean isPalindrome(String str){
        if(str==null){
            return false;
        }
        int left=0;
        int right=str.length()-1;
        while(left<right){
            if(Character.toLowerCase(str.charAt(left))!=Character.toLowerCase(str.charAt(right))){
                return false;
            }
            right--;
            left++;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the strimg:");
        String a=sc.nextLine();
        System.out.println(a + "is palindrome:" + isPalindrome(a) );
    }
}