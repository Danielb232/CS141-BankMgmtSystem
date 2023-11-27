	
import java.util.Random;

public class Customer {

    static Random rand = new Random();

    private int age;
    private String name;
    private String password;
    private String UserName;
    private double balance;
    private int transferID;
   
    
    
    public Customer(String newUser, String newPassword, String newName, int newBalance, int transferID){
        this.name = newName;
        this.password = newPassword;
        this.UserName = newUser;
        this.balance = newBalance;
        this.transferID = rand.nextInt(999999);
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
