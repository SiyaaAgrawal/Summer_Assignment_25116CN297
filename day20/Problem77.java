import java.util.*;
public class Problem77 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of rows:");
        int n=sc.nextInt();
        System.out.println("Enter no. of columns:");
        int m=sc.nextInt();
        int mat1[][]=new int[n][m];
        int mat2[][]=new int[n][m];
        int MultiplyMat[][]=new int[n][m];
        System.out.println("Enter elements in mat1:");
        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                mat1[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter elements in max2:");
        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                mat2[i][j]=sc.nextInt();
            }
        }
        System.out.println("Multiply of matrices:");
        for (int i=0;i<n;i++){
            for (int k=0;k<m;k++){
                 for(int j=0;j<m;j++){
                    MultiplyMat[i][k]+=mat1[i][j]*mat2[j][k];
                 }
                System.out.print(MultiplyMat[i][k]+"\t");
            }
            System.out.println();
        } 
    }
}


