import java.util.*;
public class Problem55{
    public static int SecondLargest(int arr[]){
        if (arr==null || arr.length<2){
            return Integer.MIN_VALUE;

        }
        int largest=Integer.MIN_VALUE;
        int secondlargest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                secondlargest=largest;
                largest=arr[i];
            }
            else if(arr[i]>secondlargest && arr[i] !=largest){
                secondlargest=arr[i];
            }
        }
        return secondlargest;
    }
    public static void main(String[] args){
        int arr[]={3,43,6};
        int result=SecondLargest(arr);
        if(result==Integer.MIN_VALUE){
            System.out.println("No valid second largest element:");
        } else{
            System.out.println("The second largest element:"+result);
        }

    }
    
}
