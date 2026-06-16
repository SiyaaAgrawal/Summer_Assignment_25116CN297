import java.util.Scanner;
import java.util.Arrays;
public class Problem49{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the array:");
        int n=sc.nextInt();
        int []arr=new int[n];
        System.out.println("Enter"+ n+"elements:");
        for(int i=0;i<n;i++){
        arr[i]=sc.nextInt();
        }
        System.out.println("Display the elements:");
        for(int i=0;i<=n;i++){
            System.out.println(arr[i]+" ");
        }

    }
}