public class Problem31 {
    public static void main(String[] args){
        int rows=5;
        for(int i=1;i<=rows;i++){
            char ch='A';
            for(int j=1;j<=i;j++){
                System.out.print(ch+" ");
                ch++;
            }
            System.out.println();
        }
    }
}
