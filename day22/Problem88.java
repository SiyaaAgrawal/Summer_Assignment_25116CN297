import java.util.*;
public class Problem88 {
    public static String removeSpaces(String a) {
        char[] arr = a.toCharArray();
        int n = arr.length;
    
        for (int i = 0; i < n; i++) {
            if (arr[i] == ' ') {
                for (int j = i; j < n - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                n--;
                i--;
            }
        }
        return new String(arr, 0, n); 
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string");
        String a=sc.nextLine();
        System.out.print(removeSpaces(a));
    }
}
