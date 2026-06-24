import java.util.*;
public class Problem86 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        
        int count = countWords(sentence);
        System.out.println("Word count: " + count);
        
        scanner.close();
    }

    public static int countWords(String str) {
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }
        String[] words = str.trim().split("\\s+");
        
        return words.length;
    }
}
