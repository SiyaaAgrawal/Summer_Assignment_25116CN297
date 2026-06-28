import java.util.*;
public class Problem103{
    public static final Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
        BankAccount UserAccount=new BankAccount(1000.00, 1234);
        System.out.println("----Welcome to the Automated TEller Machine----");
        if(!authenticateUser(UserAccount)){
            System.out.println("Card Blocked:Too many incorrect attempts:");
            return;
        }
        runTransaction(UserAccount);
    }
    private static boolean authenticateUser(BankAccount account){
        int maxAttempts=3;
        for(int attempt=1;attempt<=maxAttempts;attempt++){
            System.out.print("Enter your 4 digit security PIN:");
            while(!sc.hasNextInt()){
                System.out.println("Invalid type:PIN must be numbers only.");
                System.out.print("Enter your four digit PIN:");
            }
            int enteredPin=sc.nextInt();
            if(account.validatePin(enteredPin)){ 
                System.out.printf("Authentication Sucessful!",account.getAccountHolder());
                return true;
            }else{
                int remaining=maxAttempts-attempt;
                System.out.printf("Incorrect PIN.(attempts remaining",remaining);
            }
        }
        return false;
    }
    private static void runTransaction(BankAccount account){
        boolean exitRequested=false;
        while(!exitRequested){
            System.out.println("\n--------------------------");
            System.out.println("       ATM MAIN MENU       ");
            System.out.println("-----------------------------");
            System.out.println("1.Check Account Balance");
            System.out.println("2.Deposit Funds");
            System.out.println("3.Withdraw Cash");
            System.out.println("Exit Session");
            System.out.print("Please choose an operation(1-4)");
            if(!sc.hasNextInt()){
                System.out.println("Invalid selection.Please input numbers 1 through 4.");
                sc.next();
                continue;
            }
            int selection=sc.nextInt();
            switch(selection){
                case 1:
                    System.out.printf("Your current balance is:$%.2f%n",account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount:$");
                    double depositAmt=fetchValidAmount();
                    account.deposit(depositAmt);
                    break;
                case 3:
                    System.out.println("Enter withdrawal amount:$");
                    double withdrawAmt=fetchValidAmount();
                    account.withdraw(withdrawAmt);
                    break;
                case 4:
                    System.out.println("Thank you for choosing our banking services.");
                    exitRequested=true;
                    break;
                default:
                    System.out.println("Error:Selection out of bounds.");            
            }
        }
    }
    public static double fetchValidAmount(){
        while(!sc.hasNextDouble()){
            System.out.println("Invalid input format.Enter a clean valid decimal number.");
            System.out.print("Enter Amount:");
            sc.next();
        }
        return sc.nextDouble();
    }
}
class BankAccount{
    private String accountHolder;
    private double balance;
    private int pin;

    public BankAccount(double initialBalance,int securePin){
        this.accountHolder=accountHolder;
        this.balance=initialBalance;
        this.pin=securePin;
    }
    public String getAccountHolder(){
        return accountHolder;
    }
    public boolean validatePin(int enteredPin){
        return this.pin==enteredPin;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.printf("Successfully deposited$%.2f%n",amount);
        }
        else{
            System.out.println("Invalid deposit amount.");
        }
    }
    public boolean withdraw(double amount){
        if(amount<=0){
            System.out.println("Invalid withdrawl amount:");
            return false;
        }
        if(amount>balance){
            System.out.println("Transaction declined:");
            return false;
        }else{
            balance-=amount;
            System.out.printf("Successfully withdraw:$%.2f%n",amount);
            return true;
        }
    }
}
