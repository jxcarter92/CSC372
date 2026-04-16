package superClass;

public class CheckingAccount extends BankAccount {

	private double interestRate;
	// Constructor: initializes the CheckingAccount with account holder info and interest rate
	// Calls the parent BankAccount constructor via super() to set firstName, lastName, and accountID
	// then sets the interestRate specific to the CheckingAccount
	
	public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
		super(firstName, lastName, accountID);
		this.interestRate = interestRate;
	}

	// processWithdrawal: handles withdrawal requests with overdraft protection
	// If the withdrawal amount exceeds the current balance, the withdrawal is still processed
	// but an additional $30 overdraft fee is charged and the user is notified
	// If sufficient funds exist, the withdrawal is processed normally
	// Uses the inherited withdrawal() method from BankAccount to subtract from balance
	public void processWidrawal(double amount) {
		
		if (amount > getBalance()) {
			withdrawal(amount);// subtract the requested amount
			withdrawal(30);// apply $30 overdraft fee
			System.out.println("Withdrawal amount: " + amount);
			System.out.println("insuficient funds! Overdraft fee of $30 has been proceessed with this withdrawal");
			System.out.println("Current Balance: " + getBalance());
		}else {
			
			withdrawal(amount);// sufficient funds, process normally
			System.out.println("Withdrawal amount: " + amount);
			System.out.println("Current Balance: " + getBalance());
		}
		
	}
	
	// displayAccount: displays the full account summary including projected balance with interest
	// balanceInterest calculates the interest earned by multiplying current balance by interest rate
	// newBalance adds the interest to the current balance to show what the balance would look like
	// Calls the inherited accountSummary() method from BankAccount to display basic account info
	// then displays the interest rate and the projected balance with interest applied
	
	public void displayAccount(){
		
		double balanceInterest = getBalance() * interestRate;// calculates interest earned
		double newBalance = getBalance() + balanceInterest; // adds interest to current balance
		accountSummary(); //inherited from BankAccount, prints name, ID, and balance
		System.out.println("Interest rate: " + interestRate);
	
		System.out.println("Balance w/ interest: "  + newBalance );
	} 
	// applyInterest: applies the interest to the account by calculating and depositing the interest earned
	// Multiplies the current balance by the interestRate to calculate the interest amount
	// Then calls the inherited deposit() method from BankAccount to add the interest to the balance
	// Example: balance of $1500 with 0.05 interest rate would deposit $75 into the account
	public void applyInterest() {
		deposit(getBalance() * interestRate); // calculates and deposits interest into account
	}
	
	
}
