import java.util.*;
class BankAccount{
    private final String accountNumber;
    private final String accountHolder;
    private double balance;

    private BankAccount(String accountNumber,String accountHolder,double initialBalance){
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
        this.balance=initialBalance;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public String getAccountHolder(){
        return accountHolder;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        if(amount > 0 && amount<=balance){
            balance-=amount;
            System.out.printf("Sucess withdrew $%.2f.Remaining balance:$%.2f\n",amount,balance);
        }else if(amount>balance){
            System.out.println("Insufficient funds for this withdrawl.");
        }else{
            System.out.println("Invalid withdrawl amount.");
        }
    }
}
public class Problem110 {
    private static final Map<String, BankAccount>accounts=new HashMap<>();
    private static final Scanner sc= new Scanner(System.in);
    public static void main(String[] args){
        while(true){
            System.out.println("\n====Bank Account System====");
            System.out.println("1.Create Account.");
            System.out.println("2.Deposit Money");
            System.out.println("3.Withdraw money");
            System.out.println("4. Check Balance");
            System.out.println("5.Exit");
            System.out.println("Select an option.");
            int choice=getIntInput();
            switch(choice){
                case 1 -> createAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> checkBalance();
                case 5 -> {
                    System.out.println("Thank you");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }

        }
    }
    private static void createAccount(){
        System.out.println("Enter Account Number:");
        String number=sc.nextLine().trim();
        if(accounts.containsKey(number)){
            System.out.println("Error:An account with this number already exist.");
            return;
        }
        System.out.print("Enter account holder name:");
        String name=sc.nextLine().trim();
        
        System.out.println("Enter initial deposit.");
        double balance=getDoubleInput();

        if(balance<0){
            System.out.println("Initial deposit cannot be negative.");
            return;
        }
        BankAccount account=new BankAccount(number,name,balance);
        accounts.put(number,account);
        System.out.println("Account Succesfully created.");
    }
    private static void deposit(){
        BankAccount account=findAccount();
        if(account != null){
            System.out.println("Enter deposit amount:");
            double amount=getDoubleInput();
            account.deposit(amount);
        }
    }
    private static void withdraw(){
        BankAccount account=findAccount();
        if(account!=null){
            System.out.println("Enter withdrawl amount:");
            double amount=getDoubleInput();
            account.withdraw(amount);
        }
    }
    private static void checkBalance(){
        BankAccount account=findAccount();
        if(account!=null){
            System.out.printf("Account holder:%s\n",account.getAccountHolder());
            System.out.printf("Current Balance:$%.2f\n");
        }
    }
    private static BankAccount findAccount(){
        System.out.println("Enter account number:");
        String number=sc.nextLine().trim();
        BankAccount account=accounts.get(number);
        if(account==null){
            System.out.println("Account not found.");
        }
        return account;
    }
    private static int getIntInput(){
        while(!sc.hasNextInt()){
            System.out.println("Invalid entry.");
            sc.next();
        }
        int value=sc.nextInt();
        sc.nextLine();
        return value;
    }
    private static double getDoubleInput(){
        while(!sc.hasNextDouble()){
            System.out.println("Invalid Entry.Enter an amount:");
            sc.next();
        }
        double value=sc.nextDouble();
        sc.nextLine();
        return value;
    }
}
