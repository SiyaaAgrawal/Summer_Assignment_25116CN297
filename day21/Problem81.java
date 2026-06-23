import java.util.*;
public class Problem81{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string:");
        String a=sc.nextLine();
        int count=0;
        for(char ch:a.toCharArray()){
            count++;
        }
        System.out.print("length of the string is:"+count);
    }
}