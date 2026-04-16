package superClass;


public class BankAccount {

	private String firstName;
	private String lastName;
	private int accountID;
	private double balance;
	
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
	
	
	public BankAccount(String firstName, String lastName, int accountID) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountID = accountID;
		this.balance = 0; 
	}
	public void deposit(double deposit) {
		balance  += deposit; 
	}
	
	public void withdrawal(double withdrawal) {
		balance -= withdrawal;
		
	}
	
	public void accountSummary() {
		
		System.out.println("First name is: " + getFirstName());
		System.out.println("Last name is: " + getLastName());
		System.out.println("Account ID: " + getAccountID());
		System.out.println("Deposit amount in account: " + getBalance());
	}
	
	
}

