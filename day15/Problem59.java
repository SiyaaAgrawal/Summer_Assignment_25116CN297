import java.util.*;
public class Problem59{
    public static void main(String[] args){
        int arr[]={1,2,3,4};
        int k=2;
        System.out.println("Original Array:"+Arrays.toString(arr));
        rotateRight(arr,k);
        System.out.println("rotated Array:"+Arrays.toString(arr));
    }
    public static void rotateRight(int arr[],int k){
        if (arr==null|| arr.length==0){
            return;
        }
        int n=arr.length;
        k=k % n;
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
    }
    private static void reverse(int arr[],int start,int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}