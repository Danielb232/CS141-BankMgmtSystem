
import java.util.ArrayList;
import java.util.Scanner;

public class BankManager {

    private static Scanner scnr = new Scanner(System.in);

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

        }

    }
}