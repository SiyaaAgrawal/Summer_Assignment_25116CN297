import java.util.*;

public class Problem50{
    public static void main(String[] args){
        int[] arr={10,20,30,40};
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        double average=(double)sum/arr.length;
        System.out.print("Sum of the elements:"+sum);
        System.out.println("Average of the elements:"+average);
        
    }
}