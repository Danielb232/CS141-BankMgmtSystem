
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class BankManager {
    
    private static Scanner scnr = new Scanner(System.in);
    static Random rand = new Random();

    // int indexPosition; (
    public static void loginToAcc(ArrayList<BankManager> accounts, Scanner scnr) {
        System.out.println("Please enter your username: ");
        String userName = scnr.nextLine();
        
        System.out.println("Please enter your password ");
        String passWord = scnr.nextLine();
        
        for(Customer i : accounts) {

            if ((i.getUserName().equals(userName)) && (i.getPassword().equals(passWord))) {
                System.out.println("\nLogin Successful!");
                System.out.println("Hello, " + i.getName());
                //  indexPosition = i;
                //

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
                        transfer();
                        break;
                    }
                    case 5: {
                        i.printTransactions();
                        break;
                    }
                    case 6: {
                        i.logOut();
                        break;
                    }

                }
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
            double newBalance = scnr.nextInt();
            
            Customer newCustomer = new Customer(newUser, newPassword, newName, newBalance, newAge, _________ );
            accounts.add(newCustomer);

            System.out.println("\nYour transfer ID is " + newCustomer.getTransferID() + ".");

        }


        public static void deposit(Customer c, Scanner scnr) {
            System.out.println("How much money would you like to deposit into your account?");
            double amount = scnr.nextDouble();        
            

            if (amount < 1.00) {
                System.out.println("You must deposit at least $1.00");
            }
            else {
                c.deposit(amount);
                // FIX THIS
            }

        }

        public static void withdraw(Customer c, Scanner scnr){
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
                // FIX THIS
            }  
        }

        public static void viewBalance(Customer c) {
            System.out.println("Transfer ID:" + c.getTransferID());
            System.out.println("Balance:" + c.getBalance());
        }

        public static void transfer(ArrayList<Customer> accounts, Scanner scnr) {
            System.out.println("Enter transfer ID of user to transfer to: ");
            double transferAmount = scnr.nextDouble();

            // If the transfer ID does not exist, say it doesnt
            // if it does, say "are you sure?", then if they say "yes",
            // Add the amount to the account that is connected to that transfer ID
        
        }

        public static void printTransactions () {
            // We need an array list that stores all the transaction messages from deposit & withdraw.
            // We would print that array list here
            //
            // Add an array list to the customer
        }

        public static void logOut() {
            // Just logout
        }
    }