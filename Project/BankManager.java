
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class BankManager {
    
    private static Scanner scnr = new Scanner(System.in);
    static Random rand = new Random();

    
    public static void loginToAcc(ArrayList<BankManager> accounts, Scanner scnr) {
        System.out.println("Please enter your username: ");
        String userName = scnr.nextLine();
        
        System.out.println("Please enter your password ");
        String passWord = scnr.nextLine();
        
        for(Customer i : accounts) {
            if(!(i.getUserName().equals(userName)) || (!(i.getPassword().equals(passWord)))) {
                System.out.print("Username/Password doesn't exist, try again");
                return;
            }
            else if ((i.getUserName().equals(userName)) && (i.getPassword().equals(passWord))) {
                System.out.println("\nLogin Successful!");
                System.out.println("Hello, " + i.getName());

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
            }
            
        }
        
        public static void addAccount(ArrayList<BankManager> accounts, Scanner scnr) {
            
            System.out.println("Please enter new username");
            String newUser = scnr.nextLine();
            System.out.println("Please enter new password");
            String newPassword = scnr.nextLine();
            System.out.println("Please enter your name");
            String newName = scnr.nextLine();
            scnr.nextLine();
            System.out.println("Please enter your age");
            int newAge = scnr.nextInt();
            System.out.println("Please enter your initial deposit");
            int newBalance = scnr.nextInt();
            
            Customer newCustomer = new Customer(newUser, newPassword, newName, newBalance, newAge);
            System.out.println("\nYour transfer ID is " + newCustomer.getTransferID() + ".");

        }


        public static void deposit(ArrayList<Customer> accounts, Scanner scnr) {
            System.out.println("How much money would you like to deposit into your account?");
            double amount = scnr.nextDouble();
            
            
            
        }
    }