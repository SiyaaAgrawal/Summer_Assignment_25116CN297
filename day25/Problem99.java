import java.util.*;
public class Problem99 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("enter no. of elements:");
        int n=sc.nextInt();
        String arr[]=new String[n];
        System.out.println("Enter the string:");
        Scanner sc1=new Scanner(System.in);
        for(int i=0;i<n;i++){
            arr[i]=sc1.nextLine();
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i].compareTo(arr[j])>0){
                    String temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.print(Arrays.toString(arr));

    }
    
}
