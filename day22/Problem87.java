import java.util.*;
public class Problem87 {
    
    public static String modifyString(String s) {
    
        String res = "";
        int n = s.length();
        
        // loop through the string
        for (int i = 0; i < n; i++) {
            
            // count the occurrence of s[i]
            int count = 1;  
            
            // check if the character has been 
            // processed already
            boolean seen = false;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    seen = true;
                    break;
                }
            }
            
            if (seen) continue; 
        
            // count frequency of s[i]
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    count++;
                }
            }
            res += s.charAt(i) + Integer.toString(count) + " ";
        }
    
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string:");
        String s = sc.nextLine();
        System.out.println(modifyString(s));
    }
}
