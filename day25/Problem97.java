import java.util.*;
public class Problem97{
    public static int []merged(int arr1[],int arr2[]){
        int n=arr1.length;
        int m=arr2.length;
        int merge[]=new int [n+m];
        int i=0;
        int j=0;
        int k=0;
        while(i<n&&j<m){
            if(arr1[i]<=arr2[j]){
                merge[k]=arr2[j];
                i++;
            }else{
                merge[k]=arr2[j];
                j++;
            }
            k++;
        }
        while(i<n){
            merge[k]=arr1[i];
            i++;
            k++;
        }
        while(j<m){
            merge[k]=arr2[j];
            j++;
            k++;
        }
        return merge;
    }
    public static void main(String[] args){
        int arr1[]={1,3,2,4};
        int arr2[]={1,6,5,7,3};
        int result[]=merged(arr1,arr2);
        System.out.println("Merged array:"+Arrays.toString(result));

    }
}