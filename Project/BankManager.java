import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class BankManager {
    
    private static Scanner scnr = new Scanner(System.in);
    static Random rand = new Random();
    
    // Method to handle the login process for a customer
    public static void loginToAcc(ArrayList<Customer> accounts, Scanner scnr) {
        
        // Prompt the user for username and password
        System.out.println("Please enter your username: ");
        scnr.next();
        String userName = scnr.nextLine();
        
        
        System.out.println("Please enter your password: ");
        String passWord = scnr.nextLine();
        
        // Check if there are accounts in the system
        if (accounts.size() == 0) {
            System.out.print("\nThere are no accounts in the system.\nPlease create an account.\n");
        } else {
            // Iterate through accounts to find a matching username and password
            for (Customer i : accounts) {
                if ((i.getUserName().equals(userName)) && (i.getPassword().equals(passWord))) {
                    // If a match is found, log in and display the customer menu
                    System.out.println("\nLogin Successful!");
                    System.out.println("\nHello, " + i.getName());
                    
                    // Loop to handle actions after successful login
                    boolean loggedIn = true;
                    while (loggedIn) {
                        // Display menu for logged-in customers
                        System.out.println("\nMenu: ");
                        System.out.println("#1 - Deposit.");
                        System.out.println("#2 - Withdraw.");
                        System.out.println("#3 - View Balance & account info");
                        System.out.println("#4 - Transfer Money to another account.");
                        System.out.println("#5 - Print Transaction History.");
                        System.out.println("#6 - Log out and go back to the main menu.\n");
                        
                        // Prompt the user for a choice
                        System.out.println("\nEnter your choice (1-6): ");
                        int choice1;
                        
                        // Input validation loop for the choice
                        do {
                            while (!scnr.hasNextInt()) {
                                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                                scnr.next();
                            }
                            
                            choice1 = scnr.nextInt();
                            scnr.nextLine();
                            
                        } while (choice1 < 1 || choice1 > 6);
                        
                        // Perform actions based on the user's choice
                        if (choice1 == 6) {
                            System.out.println("\nBye!");
                            break;
                        }
                        
                        // Switch statement to handle different choices
                        switch (choice1) {
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
                                printTransactions(i);
                                break;
                            }
                            case 6: {
                                loggedIn = false;
                                break;
                            }      
                        }
                    }
                    break;
                } else {
                    // If no match is found, prompt the user to try again
                    System.out.print("\nUsername/Password not found, try again");
                }
            }
        }
    }
    
    // Method to add a new customer account
    public static void addAccount(ArrayList<Customer> accounts, Scanner scnr) {
        // Prompt the user for information to create a new account
        System.out.println("Please enter new username:");
        scnr.next();
        String newUser = scnr.nextLine();
        
        System.out.println("Please enter new password:");
        String newPassword = scnr.nextLine();
        
        System.out.println("Please enter your name:");
        String newName = scnr.nextLine();
        
        System.out.println("Please enter your age:");
        int newAge = 0;
        
        // Input Validation
        while(!scnr.hasNextInt()) {
            System.out.print("Please enter a number for your age:\n");
            scnr.next();
        }
        
        newAge = scnr.nextInt();
        
        if (newAge < 16) {
            System.out.print("\nYou are too young to create an account.\nYou must be 16 or older to create an account.\n1");
            return;
        }
        
        System.out.println("Please enter your initial deposit:");
        double newBalance = 0;
        
        while ((!scnr.hasNextDouble())) {
            System.out.print("Please enter a number for your initial deposit\n");
            scnr.next();
        }
        
        newBalance = scnr.nextDouble();
        
        if (newBalance < 100) {
            System.out.print("\nYou do not have enough money to open an account at this time.\nYou must have an initial deposit of $100.\n");
            return;
        }
        
        // Create a new Customer object and add it to the accounts
        Customer newCustomer = new Customer(newUser, newPassword, newName, newBalance, newAge);
        accounts.add(newCustomer);
        
        // Display the transfer ID for the new customer
        System.out.println("\nYour transfer ID is " + newCustomer.getTransferID() + ". Save this!");
        
    }
    
    // Method to handle the deposit process
    public static void deposit(Customer c, Scanner scnr) {
        
        System.out.println("How much money would you like to deposit into your account?");
        double amount = scnr.nextDouble();
        
        // Check if the amount is valid
        if (amount < 1.00) {
            System.out.println("You must deposit at least $1.00");
        } else {
            // Perform the deposit and update the transaction log
            String depositMessage = ("Deposited $" + amount);
            
            // Deposit amount and add deposit message to the account's transaction arraylist
            c.deposit(amount, depositMessage);
            System.out.println(depositMessage);
            
        }
    }
    
    // Method to handle the withdrawal process
    public static void withdraw(Customer c, Scanner scnr) {
        System.out.println("How much money would you like to withdraw from your account?");
        double amount = scnr.nextDouble();
        
        // Check if the amount is valid and if there are sufficient funds
        if (amount > c.getBalance()) {
            System.out.println("Insufficient Funds. You cannot withdraw more than $" + c.getBalance());
            return;
        }
        
        if (amount < 1.00) {
            System.out.println("You must withdraw at least $1.00");
        } else {
            // Perform the withdrawal and update the transaction log
            String withdrawMessage = ("Withdrew $" + amount);
            
            // Withdraw amount and add withdraw message to the account's transaction arraylist
            c.withdraw(amount, withdrawMessage);
            System.out.println(withdrawMessage);
        }
    }
    
    // Method to view the balance and account information
    public static void viewBalance(Customer c) {
        System.out.println("\nTransfer ID:" + c.getTransferID());
        System.out.printf("Balance: %.2f", c.getBalance());
        System.out.print("\n");
    }
    
    // Method to handle the money transfer process
    public static void transfer(Customer c, ArrayList<Customer> accounts, Scanner scnr) {
        System.out.println("Enter transfer ID of user to transfer to: ");
        double inputTransferID = scnr.nextDouble();
        System.out.println("Enter the amount you would like to transfer: ");
        double transferAmount = scnr.nextDouble();
        
        boolean transferCompleted = false;
        
        // Iterate through accounts to find the recipient with the given transfer ID
        for (Customer i : accounts) {
            if (i.getTransferID() == inputTransferID) {
                // Confirm the transfer with the user and update balances and logs
                System.out.println("Are you sure you want to transfer $" + transferAmount + " to " + i.getName() + "?" + "\n  1. yes \n  2. no");
                
                int choice = 0;

                do {
                    // Check if the input is an integer
                    if (!scnr.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number between 1 and 3.");
                        
                        // Consume invalid input to avoid an infinite loop
                        scnr.next();
                        continue;
                    }
                    
                    // Read the user's input as an integer
                    choice = scnr.nextInt();
                    
                    // Check if the entered choice is outside the valid range
                    if (choice < 1 || choice > 3) {
                        System.out.println("Invalid input. Please enter a number between 1 and 3.");
                    }
                    
                } while (choice < 1 || choice > 3);
                
                transferCompleted = true;
                
                if (choice == 1) {                    
                    String transferredIntoMessage = ("Transferred $" + transferAmount + " to " + i.getName() + "\n");
                    String transferredFromMessage = ("$" + transferAmount + " transferred from " + c.getName());
                    
                    // Deposit amount and withdraw amount and add transfer message into their respective transaction logs
                    i.deposit(transferAmount, transferredFromMessage);
                    c.withdraw(transferAmount, transferredIntoMessage);
                    
                    System.out.print(transferredIntoMessage);
                    
                    break;
                }
                if (choice == 2) {
                    System.out.println("\nTransfer Declined.");
                    break;
                }
            }
        }
        // Display a message if the transfer ID does not exist
        if (!transferCompleted) {
            System.out.println("Transfer ID does not exist.");
        }
    }
    
    // Method to print transaction history for a customer
    public static void printTransactions(Customer c) {
        System.out.print("\n");
        c.printLog();
    }
    
}

