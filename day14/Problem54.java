import java.util.Scanner;
public class Problem54{
    public static void main(String[] args){
        int arr[]={10,5,12,10,15};
        int n=arr.length;
        boolean visit[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(visit[i]){
                continue;
            }
            int count=1;
            for(int j=i+1;j<n;j++){
                if(arr[i]==arr[j]){
                    visit[i]=true;
                    count++;
                }
            }
            System.out.println(arr[i]+"occurs"+count+"times.");
        }
    }
}