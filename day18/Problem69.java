import java.util.*;
public class Problem69{
    public static void bubbleSort(int arr[]){
        int n=arr.length;
        boolean swapped;
        for(int i=0;i<n-1;i++){
            swapped=false;
            for (int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped =true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
    public static void main(String[] args){
        int data[]={64,34,12,22,33};
            System.out.println("Original Array:"+Arrays.toString(data));
            bubbleSort(data);
            System.out.println("Sorted Array:"+Arrays.toString(data));

    }
}