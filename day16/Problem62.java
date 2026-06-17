import java.util.*;
public class Problem62 {
    public static int MaxFrequency(int arr[]){
        int maxElement=arr[0];
        int maxCount=0;
        for(int i=0;i<arr.length;i++){
            int count=0;
            for(int j=0;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count>maxCount){
                maxCount=count;
                maxElement=arr[i];
            }
        }
        System.out.println("Maximum Frequency:"+maxCount);
        return maxElement;

    }
    public static void main(String[] args){
        int arr[]={4,5,8,5,4};
        int result=MaxFrequency(arr);
        System.out.println("Element with maximum frequency:"+ result);
        

    }
    
}
