package superClass;

//BankAccountTest: main class used to test the CheckingAccount and BankAccount classes
//Creates two separate instances of CheckingAccount to test different scenarios
public class BankAccountTest {

	public static void main(String[] args) {
		
		CheckingAccount account = new CheckingAccount("Jose", "carter", 1223, 0.05);
		
		account.deposit(1500);  // deposits $1500 into the account
		account.displayAccount(); // displays account summary with projected interest
		account.applyInterest(); // applies 5% interest to the balance
		account.processWidrawal(500);// withdraws $500, sufficient funds available
		
		System.out.println("");
		
		 // Test case 2: Overdraft scenario
        // Creates a second separate instance of CheckingAccount with same starting conditions
		CheckingAccount account1 = new CheckingAccount("Jose", "carter", 1223, 0.05);
		account1.deposit(1500);
		account1.displayAccount();
		account1.applyInterest();
		account1.processWidrawal(2500); //triggers overdraft fee and attempts to withdrawal 2500
		
		
		
	}

}
