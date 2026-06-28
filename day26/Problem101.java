import java.util.*;
public class Problem101{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Random a=new Random();
        int targetNumber=a.nextInt(100)+1;
        int guess=0;
        int attempts=0;
        System.out.println("Welcome!Guess a number between 1 and 100.");
        while(guess!=targetNumber){
            System.out.print("Enter your guess:");
            if(!sc.hasNextInt()){
                System.out.println("Invalid output:");
                sc.next();
                continue;
            }
            guess=sc.nextInt();
            attempts++;
            if(guess<targetNumber){
                System.out.println("too low.");
            }else if(guess>targetNumber){
                System.out.println("Too high.");
            }else{
                System.out.println("Correct!Attempts:"+attempts);
            }

        }
    }
}