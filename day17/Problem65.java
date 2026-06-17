import java.util.*;
public class Problem65{
    public static void main(String[] args) {
        int arr1[]={1,2,3,4};
        int arr2[]={4,5,6};
        int result[]=new int[arr1.length+arr2.length];
        System.arraycopy(arr1,0,result,0,arr1.length);
        System.arraycopy(arr2,0,result,arr1.length,arr2.length);
        System.out.println(Arrays.toString(result));
    }
}