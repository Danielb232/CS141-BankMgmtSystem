
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class BankManager {
    
    private static Scanner scnr = new Scanner(System.in);
    static Random rand = new Random();
    
    
    public static void loginToAcc(ArrayList<Customer> accounts, Scanner scnr) {
        
        System.out.println("Please enter your username: ");
        String userName = scnr.nextLine();
        
        System.out.println("Please enter your password ");
        String passWord = scnr.nextLine();
        
        if(accounts.size() == 0 ){
            System.out.print("\nThere are no accounts in the system.\nPlease create an account.\n");
        }
        
        else if(accounts.size() > 0) {
            for(Customer i : accounts) {
                
                if ((i.getUserName().equals(userName)) && (i.getPassword().equals(passWord))) {
                    System.out.println("\nLogin Successful!");
                    System.out.println("\nHello, " + i.getName());
                    
                    boolean loggedIn = true;
                    while (loggedIn) {
                        System.out.println("\nMenu: ");
                        System.out.println("#1 - Deposit.");
                        System.out.println("#2 - Withdraw.");
                        System.out.println("#3 - View Balance & account info");
                        System.out.println("#4 - Transfer Money to another account.");
                        System.out.println("#5 - Print Transaction History.");
                        System.out.println("#6 - Log out and go back to main menu.\n");
                        
                        System.out.println("\nEnter your choice (1-6): ");
                        
                        int choice1;
                        
                        
                        do {
                            
                            while (!scnr.hasNextInt()) {
                                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                                scnr.next();
                            }
                            
                            choice1 = scnr.nextInt();
                            scnr.nextLine();
                            
                        } while (choice1 < 1 || choice1 > 6);
                        
                        if (choice1 == 6) {
                            System.out.println("\nBye!");
                            break;
                        }
                        
                        switch(choice1) {
                            case 1: {
                                deposit(i, scnr);
                                break;
                            }
                            case 2: {
                                withdraw(i, scnr);
                                break;
                            }
                            case 3: {
                                viewBalance(i);
                                break;
                            }
                            case 4: {
                                transfer(i, accounts, scnr);
                                break;
                            }
                            case 5: {
                                i.printTransactions();
                                break;
                            }
                            case 6: {
                                loggedIn = false;
                                break;
                            }
                            
                        }
                    }
                    break;
                }
                
                else {
                    System.out.print("\nUsername/Password not found, try again");
                }
                
            }
        }
    } 
    
    public static void addAccount(ArrayList<Customer> accounts, Scanner scnr) {
        
        System.out.println("Please enter new username");
        String newUser = scnr.nextLine();
        System.out.println("Please enter new password");
        String newPassword = scnr.nextLine();
        System.out.println("Please enter your name");
        String newName = scnr.nextLine();
        System.out.println("Please enter your age");
        int newAge = scnr.nextInt();
        System.out.println("Please enter your initial deposit");
        double newBalance = scnr.nextDouble();
        
        Customer newCustomer = new Customer(newUser, newPassword, newName, newBalance, newAge);
        accounts.add(newCustomer);
        
        System.out.println("\nYour transfer ID is " + newCustomer.getTransferID() + ". Save this!");
        
    }
    
    
    public static void deposit(Customer c, Scanner scnr) {
        System.out.println("How much money would you like to deposit into your account?");
        double amount = scnr.nextDouble();        
        
        
        if (amount < 1.00) {
            System.out.println("You must deposit at least $1.00");
        }
        else {
            c.deposit(amount);
            String depositMessage = ("Deposited $" + amount);
            System.out.println(depositMessage);
            c.addToLog(depositMessage);
        }
        
    }
    
    public static void withdraw(Customer c, Scanner scnr) {
        System.out.println("How much money would you like to withdraw from your account?");
        double amount = scnr.nextDouble();
        if (amount > c.getBalance()) {
            System.out.println("Insufficient Funds");
        }
        
        if (amount < 1.00) {
            System.out.println("You must withdraw at least $1.00");
        }
        else {
            c.withdraw(amount);
            String withdrawMessage = ("Withdrew $" + amount);
            System.out.println(withdrawMessage);
            c.addToLog(withdrawMessage);
        }  
    }
    
    public static void viewBalance(Customer c) {
        System.out.println("\nTransfer ID:" +  c.getTransferID());
        System.out.printf("Balance: %.2f", c.getBalance());
        System.out.print("\n");
    }
    
    public static void transfer(Customer c, ArrayList<Customer> accounts, Scanner scnr) {
        System.out.println("Enter transfer ID of user to transfer to: ");
        double inputTransferID = scnr.nextDouble();
        System.out.println("Enter the amount you would like to transfer: ");
        double transferAmount = scnr.nextDouble();
        
        boolean transferCompleted = false;
        
        for( Customer i : accounts ) {
            if (i.getTransferID()== inputTransferID) {
                System.out.println("Are you sure you want to transfer $" + transferAmount + " to " +  i.getName() + "?" + "\n  1. yes \n  2. no");
                int choice = scnr.nextInt();
                
                transferCompleted = true;
                
                if (choice == 1){
                    i.deposit(transferAmount);
                    c.withdraw(transferAmount);
                    
                    String transferredIntoMessage = ("Transferred $" + transferAmount + " to " + i.getName() + "\n");
                    c.addToLog(transferredIntoMessage);
                    String transferredFromMessage = ("$" + transferAmount + " transferred  from " + c.getName());
                    i.addToLog(transferredFromMessage);
                    System.out.print(transferredIntoMessage);
                    
                    
                    break;
                }
                if (choice == 2) {
                    System.out.println("\nTransfer Declined.");
                    break;
                }
            }
            
        }
        if (!transferCompleted) {
            System.out.println("Transfer ID does not exist.");
        }
    }
    
    
    public static void printTransactions (Customer c) {
        System.out.println("Transaction log size: " + c.getTransactionLog().size());
        c.printLog();
        
    }
    
}