package task3;

import java.util.Scanner;

public class ATM {
	private BankAccount bankAccount;

    public ATM(BankAccount account) {
        this.bankAccount = account;
    }

    public void displayOptions() {
        System.out.println("\nATM Options:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processUserChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                System.out.print("Enter deposit amount: Rs.");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter withdrawal amount: Rs.");
                double withdrawAmount = scanner.nextDouble();
                boolean success = bankAccount.withdraw(withdrawAmount);
                if (success) {
                    System.out.println("Please take your cash");
                }
                break;
            case 4:
                System.out.println("Exiting... Your transaction's done, a big thanks for choosing the ATM! ");
                break;
            default:
                System.out.println("Oops, that choice is invalid");
        }
    }

    public void checkBalance() {
        System.out.println(" Youre Current Balance Is: Rs." + bankAccount.getBalance());
    }
}
