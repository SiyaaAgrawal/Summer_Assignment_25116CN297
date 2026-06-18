import java.util.*;
    public class Problem71{
        public static int BinarySearch(int arr[],int key){
            int low=0;
            int high=arr.length-1;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(arr[mid]==key){
                    return mid;
                }
                if(arr[mid]<key){
                    low=mid+1;
                }else{
                    high=mid-1;
                }

            }
            return -1;
        }
        public static void main(String[]args){
            int arr[]={23,21,8,43,3};
            int key=43;
            int result=BinarySearch(arr,key);
            System.out.println(result);

        }
    }
