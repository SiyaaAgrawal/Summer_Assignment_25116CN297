import java.util.Scanner;
public class Problem52{
    public static void main(String[] args){
        int arr[]={12,3,56,87,23};
        int evencount=0;
        int oddCount=0;
        for(int num:arr){
            if(num%2==0){
                evencount++;
            }else{
                oddCount++;
            }
        }
        System.out.println("total even eiements:"+ evencount);
        System.out.println("total odd elements"+oddCount);
    }
}