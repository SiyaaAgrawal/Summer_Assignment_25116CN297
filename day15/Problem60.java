import java.util.*;
public class Problem60{
    public static void main(String[] args){
         int num[]={1,0,2,3};
         System.out.println("Original Arrays:"+Arrays.toString(num));
         moveZero(num);
         System.out.println("Modified Array:"+Arrays.toString(num));
    }
    public static void moveZero(int arr[]){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if (arr[i]!=0){
                arr[count]=arr[i];
                count++;
            }
        }
    }

}
