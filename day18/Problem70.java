import java.util.*;
public class Problem70 {
    public static void SelectionSort(int arr[]){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int minIndex=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            int temp=arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=temp;
        }

    }
    public static void main(String[] args){
        int data[]={64,23,56,12};
        SelectionSort(data);
        System.out.println("Sorted Array:"+Arrays.toString(data));
    }
    
}
