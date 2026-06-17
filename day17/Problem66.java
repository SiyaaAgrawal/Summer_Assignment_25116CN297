import java.util.*;
public class Problem66{
    public static void main(String[] args){
        int arr1[]={1,2,3,4};
        int arr2[]={2,3,5};
        int result[]=new int[arr1.length+arr2.length];
        int count=0;
        for(int i=0;i<arr1.length;i++){
            boolean isDuplicate=false;
            for(int j=0;j<count;j++){
                if(result[j]==arr[i]){
                    isDuplicate=true;
                    break;
                }
            }
            if(!isDuplicate){
                result[count]=arr1[i];
                count++;
            }
        }
        for(int i=0;i<arr2.length;i++){
            boolean isDuplicate=false;
            for(int j=0;j<count;j++){
                if(result[j]==arr2[i]){
                    isDuplicate=true;
                    break;
                }

            }
            if(!isDuplicate){
                result[count]=arr2[i];
                count++;
            }
        }
        int UnionResult[]=Arrays.copyOf(result,count);
        System.out.println("Array1:"+Arrays.toString(arr1));
        System.out.println("Array2:"+Arrays.toString(arr2));
        System.out.println("Union:"+Arrays.toString(unionResult));

    }
}