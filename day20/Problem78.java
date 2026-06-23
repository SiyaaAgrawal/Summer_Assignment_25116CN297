import java.util.*;
public class Problem78{
    public static boolean isSymmetric(int mat[][],int m,int n){
        if(m!=n){
            return false;
        }
        for(int i=0;i<m;i++){
            for(int j=i+1;j<n;j++){
                if(mat[i][j]!=mat[j][i]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("enter rows:");
        int n=sc.nextInt();
        System.out.print("enter columns:");
        int m=sc.nextInt();
        int mat[][]=new int [n][m];
        System.out.println("Enter elements in mat:");
        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                mat[i][j]=sc.nextInt();
            }
        }
        System.out.println("The given matrix is:");
        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                System.out.print(mat[i][j]+"\t");
            }
            System.out.println();
        }
        if(isSymmetric(mat,n,m)){
            System.out.print("The given matrix is Symmetric Matrix");
        }
        else{
            System.out.print("The given matrix is not Symmetric Matrix.");
        }
    }
}
