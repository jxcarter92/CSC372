/*
 * Author: Jose Carter
 * Course: CSC372
 * Date: 
 * Description: This class represents a BankAccount and contains
 * methods for deposit, withdrawal, and account summary.
 */

package superClass;


public class BankAccount {

	private String firstName;//private fields
	private String lastName;
	private int accountID;
	private double balance;
	//getter setters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	public double getBalance() {
		return balance;
	}
	
	// constructor using fields. Set balance to 0
	public BankAccount(String firstName, String lastName, int accountID) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountID = accountID;
		this.balance = 0; 
	}
	//deposit method for initial bank balance(balance = balance + deposit). this is called in main using instance account.deposit(1500);
	public void deposit(double deposit) {
		balance  += deposit; 
	}
	//balance for withdraw user choose from initial deposit. this is used in the processWithdrawal method in the checkingAccount class
	public void withdrawal(double withdrawal) {
		balance -= withdrawal;
		
	}
	
	public void accountSummary() {//also called in main instance would be CheckingAccount account = new CheckingAccount("Jose", "carter", 1223, 0.05);
		
		System.out.println("First name is: " + getFirstName());
		System.out.println("Last name is: " + getLastName());
		System.out.println("Account ID: " + getAccountID());
		System.out.println("Deposit amount in account: " + getBalance());
	}
	
	
}

