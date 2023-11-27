import java.util.*;

public class Caller {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        
        ArrayList<Customer> accounts = new ArrayList<>();
        
        System.out.println("-- Welcome to the Bank Management System 1.0 --");
        
        while (true) {
            // Menu for management system
            System.out.println("\nMenu: ");
            System.out.println("#1 - Login.");
            System.out.println("#2 - Create an account.");
            System.out.println("#3 - Exit");
            
            System.out.println("\nEnter your choice (1-3): ");
            
            int choice;
            
            do {
                
                while (!scnr.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number between 1 and 3.");
                    scnr.next();
                }
                
                choice = scnr.nextInt();
                scnr.nextLine();
                
            } while (choice < 1 || choice > 3);
            
            if (choice == 3) {
                System.out.println("\nBye!");
                break;
            }
            
            switch (choice) {
                case 1:
                BankManager.loginToAcc(accounts, scnr);
                break;
                case 2:
                BankManager.addAccount(accounts, scnr);
                break;
            }
            
        }
    }
    
}