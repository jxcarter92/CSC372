package superClass;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankAccountGUI {
	
	public BankAccountGUI() {
		 // Create a CheckingAccount instance with account holder info and 0.05 interest rate
        // Balance starts at $0.00 by default from BankAccount constructor
		 CheckingAccount account = new CheckingAccount("Jose", "Carter", 1223, 0.05);
		 
		// Create the main JFrame window that holds the entire GUI
		JFrame frame = new JFrame();
		// Create the main panel using BorderLayout to organize the top, center, and bottom panels
		JPanel panel = new JPanel(new BorderLayout());
		
		// Create buttons for deposit, withdrawal, clear, and exit actions
		JButton cancelButton = new JButton("Exit");
		JButton depositButton = new JButton("Deposit");
		JButton clearButton = new JButton("Clear");
		JButton withdrawalButton = new JButton("Withdrawal");
		
		// Labels to display account holder name, account ID, and current balance
		JLabel nameLabel = new JLabel("Account Holder: " + account.getFirstName() + " " + account.getLastName());
		JLabel accountIDLabel = new JLabel("Account ID: " + account.getAccountID());
		JLabel balanceLabel = new JLabel("Balance: $0.00");
		
		// Text fields for user to enter deposit and withdrawal amounts
		JTextField amountField = new JTextField(10);
		JTextField withdrawalField = new JTextField(10);
		
		// Top panel uses FlowLayout to line up deposit field, deposit button,
        // withdrawal field, and withdrawal button left to right
		JPanel topPanel = new JPanel(new FlowLayout());
		topPanel.add(amountField);
		topPanel.add(depositButton);
		topPanel.add(withdrawalField);
		topPanel.add(withdrawalButton);
		panel.add(topPanel, BorderLayout.NORTH);
		
		// Center panel displays account holder name and account ID
		JPanel centerPanel = new JPanel(new FlowLayout());
		centerPanel.add(nameLabel);
		centerPanel.add(accountIDLabel);
		panel.add(centerPanel, BorderLayout.CENTER);
		
		// Bottom panel displays current balance, clear button, and exit button
		JPanel bottomPanel = new JPanel(new FlowLayout());
		bottomPanel.add(balanceLabel);
		bottomPanel.add(clearButton);
		bottomPanel.add(cancelButton);
		panel.add(bottomPanel, BorderLayout.SOUTH);
		
		 // Deposit button ActionListener: reads amount from amountField, deposits into account
        // and updates the balance label. Shows error popup if input is not a valid number
		depositButton.addActionListener(e-> {
			try {
			double amount = Double.parseDouble(amountField.getText());
			account.deposit(amount); // calls deposit method from BankAccount
			balanceLabel.setText("Balance: $" + account.getBalance()); // updates balance display
			}catch(NumberFormatException ex) {
				 JOptionPane.showMessageDialog(null, "Please enter a valid amount!");
		    }
		});
		
		// Withdrawal button ActionListener: reads amount from withdrawalField
        // If amount exceeds balance, processWithdrawal handles overdraft fee of $30
        // and displays a popup warning. Otherwise processes normally and updates balance
		withdrawalButton.addActionListener(e ->{
			 try {
			        double amount = Double.parseDouble(withdrawalField.getText());
			        
			        if(amount > account.getBalance()) {
			            account.processWidrawal(amount);// calls processWithdrawal from CheckingAccount
			            balanceLabel.setText("Balance: $" + account.getBalance());
			            JOptionPane.showMessageDialog(null, "insuficient funds! Overdraft fee of $30 has been proceessed with this withdrawal");
			        } else {
			            account.processWidrawal(amount);// sufficient funds, process normally
			            balanceLabel.setText("Balance: $" + account.getBalance());
			        }
			        
			    } catch(NumberFormatException ex) {
			        JOptionPane.showMessageDialog(null, "Please enter a valid amount!");
			    }
		});
		
		// Clear button ActionListener: resets all text fields, balance label,
        // and account balance back to $0.00 using resetBalance from BankAccount
		clearButton.addActionListener(e ->{
			amountField.setText("");
			withdrawalField.setText("");
			balanceLabel.setText("Balance: $0.00");
			account.resetBalane();// resets actual account balance to 0
		});
		
		 // Exit button ActionListener: closes the program
        // System.exit(0) means the program closed normally with no errors
		cancelButton.addActionListener(e ->{
			System.exit(0);
		});
		
		// Add main panel to frame, set title, size, and make visible
        // setVisible must always be last
		frame.add(panel);
		frame.setTitle("Bank Account GUI");
		frame.setSize(500, 300);
		frame.setVisible(true);
		
		
	}
	
	
	// Main method: entry point of the program, launches the GUI
	public static void main(String[] args) {
		
		new BankAccountGUI();
		
		
		
	}

}
