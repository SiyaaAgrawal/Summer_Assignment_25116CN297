import java.util.*;
public class Problem58 {
    public static void leftRotate(int arr[],int d){
        if(arr==null||arr.length==0){
        return;
        }
        int n=arr.length;
        d=d%n;
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);
    }
    
    public static void reverse(int arr[],int start,int end){
        while(start<end){
          int temp =arr[start];
          arr[start]=arr[end];
          arr[end]=temp;
          start++;
          end--;
        }
    }

    public static void main(String[] args){
        int arr[]={1,3,21,13};
        int d=2;
        System.out.println("Original Array:"+Arrays.toString(arr));
        leftRotate(arr,d);
        System.out.println("Left Rotated by:"+d+"places:"+Arrays.toString(arr));
    }

}
