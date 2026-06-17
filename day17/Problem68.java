import java.util.*;
public class Problem68 {
    public static void main(String[] args){
        int arr1[]={1,2,3,9};
        int arr2[]={1,0,6,15,9};
        System.out.println("Common elements:");
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++){
                if(arr1[i]==arr2[j]){
                    System.out.println(arr1[i]+" ");
                    break;
                }
            }

        }
    }
    
}
