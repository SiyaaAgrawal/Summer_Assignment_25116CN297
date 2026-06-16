import java.util.Arrays;
public class Problem51{
    public static void main(String[]args){
        int[] arr={12,13,1,8,67};
        if(arr==null||arr.length==0){
            System.out.println("array is empty.");
            return;
        }
        int smallest=arr[0];
        int largest=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>largest){
                largest=arr[i];
            }else if(arr[i]<smallest){
                smallest=arr[i];
            }
        }
        System.out.println("smallest element:"+smallest);
        System.out.println("largest element :"+largest);
    }
}