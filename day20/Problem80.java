import java.util.*;
public class Problem80 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of rows:");
        int n=sc.nextInt();
        System.out.println("Enter no. of columns:");
        int m=sc.nextInt();
        int mat1[][]=new int[n][m];
        System.out.println("Enter elements in mat1:");
        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                mat1[i][j]= sc.nextInt();
            }
        }
        for(int i=0;i<mat1.length;i++){
            int colSum=0;
            for(int j=0;j<mat1[i].length;j++){
                colSum+=mat1[j][i];
            }
            System.out.println("Sum of col"+(i+1)+"="+colSum);

        }
    }
    
}
