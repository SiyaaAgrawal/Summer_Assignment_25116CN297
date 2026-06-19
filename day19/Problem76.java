import java.util.*;
public class Problem76 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of rows:");
        int n=sc.nextInt();
        System.out.println("Enter no. of columns:");
        int m=sc.nextInt();
        int mat1[][]=new int[n][m];
        int DiagonalSumMat=0;
        System.out.println("Enter elements in mat1:");
        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                mat1[i][j]=sc.nextInt();
            }
        }
        for (int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(i==j){
                DiagonalSumMat+=mat1[i][j];
                }
            }
        }
        System.out.println("Diagonal Sum of matrices:"+DiagonalSumMat);
    }
}


