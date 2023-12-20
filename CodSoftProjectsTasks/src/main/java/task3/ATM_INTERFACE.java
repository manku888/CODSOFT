package task3;

import java.util.Scanner;

public class ATM_INTERFACE {
	public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(10000.0); 
        ATM atmMachine = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 4) {
            atmMachine.displayOptions();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            atmMachine.processUserChoice(choice, scanner);
        }
        scanner.close();
    }
}
