public class Problem14 {
    public static void main(String[]args){
        int a =0;int b=1;
        for(int i=0; ;i++){
            System.out.print(a +" ");
            int temp=a;
            a=b;
            b=temp+b;
            if(a>100){
                break;
            }
        }
        
    
    }
}
