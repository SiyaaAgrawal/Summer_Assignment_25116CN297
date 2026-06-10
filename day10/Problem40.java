public class Problem40 {
    public static void main(String[] args){
        for(int i=1;i<=5;i++)
          {
              // this loop is for the space from i to row
              for(int j=i;j<=5;j++)
                    System.out.print(" ");
              //this loop is for print alphabet A to (J+64)
              for(int j=1;j<=i;j++)
                    System.out.print((char)(j+64)+"");
               // this loop is for the reverse order of alphabet
              for(int k=i-1;k>=1;k--)
                    System.out.print((char)(k+64)+"");
              System.out.println();
        
        }
    }
    
}
