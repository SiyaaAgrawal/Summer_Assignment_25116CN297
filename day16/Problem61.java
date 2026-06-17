import java.util.*;
public class Problem61{
    public static void main (String[] args){
        int arr[]={1,2,3,5,6};
        int n=6;
        int missingNum=MissingNumber(arr,n);
        System.out.println("The missing number is:"+missingNum);
    }
    public static int MissingNumber(int arr[],int n){
        int expectedsum=n*(n+1)/2;
        int actualSum=0;
        for(int num:arr){
            actualSum+=n;
        }
        return expectedsum-actualSum;
    }
}