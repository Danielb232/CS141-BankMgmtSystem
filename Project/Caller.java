import java.util.*;

public class Caller {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scnr = new Scanner(System.in);
        
        // Create an ArrayList to store customer accounts
        ArrayList<Customer> accounts = new ArrayList<>();
        
        // Display a welcome message
        System.out.println("-- Welcome to the Bank Management System 1.0 --");
        
        // Initialize a flag to control whether the system's running or not 
        boolean systemRunning = true;
        while (systemRunning) {
            // Display the menu for the bank management system
            System.out.println("\nMenu: ");
            System.out.println("#1 - Login.");
            System.out.println("#2 - Create an account.");
            System.out.println("#3 - Exit");
            
            // Prompt the user to enter a choice between 1 and 3
            System.out.println("\nEnter your choice (1-3): ");            
            int choice = 0; // Initialize the choice variable
            
            // Input validation loop to ensure a valid choice is entered
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
            
            // Handle special cases based on the user's choice
            if ((choice == 1) && accounts.isEmpty()) {
                System.out.print("There are no accounts in the system.\nPlease create an account to continue.\n");
            }
            
            // Exit the system if the user chooses to exit
            if (choice == 3) {
                System.out.println("\nBye!");
                systemRunning = false;
            }
            
            // Process valid choices for login or creating an account
            if (((choice == 1) && (!accounts.isEmpty())) || (choice == 2)) {
                switch (choice) {
                    case 1:
                    // Call the loginToAcc method from the BankManager class
                    BankManager.loginToAcc(accounts, scnr);
                    break;
                    case 2:
                    // Call the addAccount method from the BankManager class
                    BankManager.addAccount(accounts, scnr);
                    break;
                }
            }
        }
    }
}
