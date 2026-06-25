import java.util.*;
public class Problem93{
    public static boolean StringRotation(String a,String b){
        if(a==null||b==null||a.length()!=b.length()){
            return false;
        }
        String add=a+b;
        return add.contains(b);
    }
    public static void main (String[] args){
        Scanner sc=new Scanner (System.in);
        System.out.print("Enter the string1:");
        String a=sc.nextLine();
        System.out.println("Enter the string2:");
        String b=sc.nextLine();
        if(StringRotation(a,b)){
            System.out.println("YES "+b+"is rotation of "+a);
        }else{
            System.out.println("No"+" "+b+"is not a rotation of"+a);
        }

    }
}