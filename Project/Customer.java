	
import java.util.Random;

public class Customer {

    static Random rand = new Random();

    private int age;
    private String name;
    private String password;
    private String UserName;
    private double balance;
    private int transferID;
    private String[] transactionLog;
   
    
    
    

    public Customer(String newUser, String newPassword, String newName, double newBalance, int age, String[] transactionLog){
        this.name = newName;
        this.password = newPassword;
        this.UserName = newUser;
        this.balance = newBalance;
        this.transferID = rand.nextInt(999999);
        this.transactionLog = transactionLog;
    }
    
    public void deposit(double amount) {
        balance += amount;
        return;
    }

    public void withdraw(double amount) {
        balance -= amount;
        return;
    }

    public void viewBalance() {
        return;
    }

    public void transfer(double amount) {
        return;
    }

    public void printTransactions() {
        return;
    }

    public void logOut() {
        return;
    }

    //  Every method needs one of those ^

    public String[] getTransactionLog() {
        return transactionLog;
    }

    public void setTransactionLog(String[] transactionLog) {
        this.transactionLog = transactionLog;
    }

    public static Random getRand() {
        return rand;
    }

    public static void setRand(Random rand) {
        Customer.rand = rand;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTransferID() {
        return transferID;
    }

    public void setTransferID(int transferID) {
        this.transferID = transferID;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserName() {
        return UserName;
    }
    public void setUserName(String userName) {
        this.UserName = userName;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

   
    
    
}
