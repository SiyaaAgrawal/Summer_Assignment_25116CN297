import java.util.*;
public class Problem64{
    public static void main(String[] args){
        int arr[]={1,2,3,1,10};
        Arrays.sort(arr);
        int uniqueCount=removeDuplicates(arr);
        int result[]=Arrays.copyOf(arr,uniqueCount);
        System.out.println(Arrays.toString(result));
    }
    public static int removeDuplicates(int num[]){
        if(num.length==0){
            return 0;
        }
        int i=0;
        for(int j=1;j<num.length;j++){
            if(num[j]!=num[i]){
                i++;
                num[i]=num[j];
            }
        }
        return i+1;
    }
}