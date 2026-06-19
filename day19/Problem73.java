import java.util.*;
public class Problem73 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of rows:");
        int n=sc.nextInt();
        System.out.println("Enter no. of columns:");
        int m=sc.nextInt();
        int mat1[][]=new int[n][m];
        int mat2[][]=new int[n][m];
        int SumMat[][]=new int[n][m];
        System.out.println("Enter elements in mat1:");
        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                mat1[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter elements in mat2:");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                mat2[i][j]=sc.nextInt();
            }
        }
        for (int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                SumMat[i][j]=mat1[i][j]+mat2[i][j];
            }
        }
        System.out.println("Sum of matrices:");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(SumMat[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
