import java.util.*;
public class Problem72 {
    public static void main(String[] args) {
        int arr[]={5,2,8,1};
        Arrays.sort(arr);
        for(int i=0;i<arr.length/2;i++){
            int temp=arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;

        }
        System.out.println(Arrays.toString(arr));

    }
    
}
