package task3;

public class BankAccount {
	 private double balance;

	    public BankAccount(double initialBalance) {
	        this.balance = initialBalance;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public void deposit(double amount) {
	        balance += amount;
	        System.out.println("Deposited: Rs." + amount);
	    }

	    public boolean withdraw(double amount) {
	        if (amount > balance) {
	            System.out.println("Insufficient funds");
	            return false;
	        } else {
	            balance -= amount;
	            System.out.println("Withdrawn: Rs." + amount);
	            return true;
	        }
	    }
}
