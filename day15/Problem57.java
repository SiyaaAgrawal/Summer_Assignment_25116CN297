import java.util.*;
public class Problem57{
    public static void reverseArray(int arr[]){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args){
        int data[]={10,12,20,7};
        reverseArray(data);
        System.out.println(Arrays.toString(data));

    }
}