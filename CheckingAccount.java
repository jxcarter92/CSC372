package superClass;

public class CheckingAccount extends BankAccount {

	private double interestRate;
	
	public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
		super(firstName, lastName, accountID);
		this.interestRate = interestRate;
	}

	public void processWidrawal(double amount) {
		
		if (amount > getBalance()) {
			withdrawal(amount);
			withdrawal(30);
			System.out.println("Withdrawal amount: " + amount);
			System.out.println("insuficient funds! Overdraft fee of $30 has been proceessed with this withdrawal");
			System.out.println("Current Balance: " + getBalance());
		}else {
			
			withdrawal(amount);
			System.out.println("Withdrawal amount: " + amount);
			System.out.println("Current Balance: " + getBalance());
		}
		
	}
	
	
	public void displayAccount(){
		
		double balanceInterest = getBalance() * interestRate;
		double newBalance = getBalance() + balanceInterest; 
		accountSummary();
		System.out.println("Interest rate: " + interestRate);
	
		System.out.println("Balance w/ interest: "  + newBalance );
	} 
	
	public void applyInterest() {
		deposit(getBalance() * interestRate);
	}
	
	
}
