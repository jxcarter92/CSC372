package superClass;

public class BankAccountTest {

	public static void main(String[] args) {
		
		CheckingAccount account = new CheckingAccount("Jose", "carter", 1223, 0.05);
		
		account.deposit(1500);
		account.displayAccount();
		account.applyInterest();
		account.processWidrawal(500);
		
		System.out.println("");
		
		CheckingAccount account1 = new CheckingAccount("Jose", "carter", 1223, 0.05);
		account1.deposit(1500);
		account1.displayAccount();
		account1.applyInterest();
		account1.processWidrawal(2500);
		
		
		
	}

}
