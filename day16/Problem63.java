import java.util.*;
public class Problem63{
    public static void findPair(int arr[],int sum){
        int left=0;
        int right=arr.length-1;
        boolean pairFound=false;
        while(left<right){
            int CurrentSum=arr[left]+arr[right];
            if(CurrentSum== sum){
                System.out.println("Pair found:("+arr[left]+","+arr[right]+")");
                pairFound=true;
                left++;
                right--;
            }
            else if(CurrentSum<sum){
                left++;
            } 
            else{
                right--;
            }
        }
        if(!pairFound){
            System.out.println("No pair found with given Sum:");
        }
        
    }
    public static void main(String[] args){
        int arr[]={1,2,5,6,4};
        int sum=6;
        findPair(arr,sum);
    }
}