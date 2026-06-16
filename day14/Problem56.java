import java.util.*;
public class Problem56{
    public static void main(String[]args){
        int arr[]={4,5,2,4};
        Arrays.sort(arr);
        System.out.print("Duplicate elements:");
        for(int i=0;i<(arr.length-1);i++){
            for(int j=i+1;j<arr.length;i++){
                if(arr[i]==arr[j]){
                    System.out.print(arr[i]+" ");
                }

            }
        }
    }
}
