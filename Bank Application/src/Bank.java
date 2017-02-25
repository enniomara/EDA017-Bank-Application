import java.util.ArrayList;

public class Bank {
	private ArrayList<Customer> customerList;
	private ArrayList<BankAccount> accountsList;
	
	/**
	 * Create an empty bank.
	 */
	public Bank() {
		customerList = new ArrayList<>();
		accountsList = new ArrayList<>();
	}

	/**
	 * Create a new account int the bank. If no customer (holder) is found,
	 * create a new Customer.
	 * 
	 * @param holderName
	 *            Name of account holder
	 * @param idNr
	 *            Id (personnr) of account holder
	 * @return Account number
	 */
	public int addAccount(String holderName, long idNr) {
		// Check that there is a user
		Customer checkCustomer = this.findHolder(idNr);
		
		// if findholder return null, it means that there is no customer so it must be created
		if(checkCustomer == null){
			checkCustomer = new Customer(holderName, idNr);
		}
		
		BankAccount accountToBeAdded = new BankAccount(checkCustomer);
		accountsList.add(accountToBeAdded);
		
		
		return accountToBeAdded.getAccountNumber();
	}

	/**
	 * Search for holder with given id.
	 * 
	 * @param idNr
	 *            Id (personnr) of holder.
	 * @return The customer if found, or null if no customer found.
	 * 
	 */
	public Customer findHolder(long idNr) {
		for (Customer customer : customerList) {
			if(customer.getIdNr() == idNr){
				return customer;
			}
		}
		
		return null;
	}

	/**
	 * Remove an account with given account number.
	 * 
	 * @param number
	 *            Account unique number
	 * @return True if successful, otherwise false.
	 */
	public boolean removeAccount(int number) {
		for (int i = 0; i < accountsList.size(); i++) {
			// If the account in the list matches the account we are looking for
			if(accountsList.get(i).getAccountNumber() == number){
				accountsList.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * Get a list of all account currently in the bank. The list is sorted by
	 * holder name.
	 * 
	 * @return List containing all accounts in bank.
	 */
	public ArrayList<BankAccount> getAllAccounts() {
		// https://moodle.cs.lth.se/mod/page/view.php?id=488
		ArrayList<BankAccount> sortedBankAccountsList = new ArrayList<>();

		for (BankAccount bankAccount : accountsList) {
			int pos = 0;
			while (pos < sortedBankAccountsList.size() && sortedBankAccountsList.get(pos).getHolder().getName().compareToIgnoreCase(bankAccount.getHolder().getName()) < 0) {
				pos++;
			}
			sortedBankAccountsList.add(pos, bankAccount);
		}
		
		return sortedBankAccountsList;
		
	}

	/**
	 * Find a specific bank account given its number (unique identifier).
	 * 
	 * @param accountNumber
	 *            Account number
	 * @return The bank account if found, otherwise null.
	 */
	public BankAccount findByNumber(int accountNumber) {
		for (BankAccount bankAccount : accountsList) {
			if(bankAccount.getAccountNumber() == accountNumber){
				return bankAccount;
			}
		}
		return null;
	}

	/**
	 * Search all bank accounts that are owned by Customer with given id
	 * (personnr). All customers have unique ids.
	 * 
	 * @param idNr
	 *            The customer's id (personnr)
	 * @return List of all accounts owned by customer.
	 */
	public ArrayList<BankAccount> findAccountsForHolder(long idNr) {
		ArrayList<BankAccount> tempBankAccount = new ArrayList<>();
		for (BankAccount bankAccount : accountsList) {
			if(bankAccount.getHolder().getIdNr() == idNr){
				tempBankAccount.add(bankAccount);
			}
		}
		return tempBankAccount;
	}

	/**
	 * Runs a case insensitive search of all customers whose name contains
	 * namePart.
	 * 
	 * @param namePart
	 *            Part of a customer's name.
	 * @return A list of all customers that contain namePart in name.
	 */
	public ArrayList<Customer> findByPartofName(String namePart) {
		ArrayList<Customer> foundNameCustomerList = new ArrayList<>();
		
		for (Customer customer : customerList) {
			if(customer.getName().toLowerCase().contains(namePart)){
				foundNameCustomerList.add(customer);
			}
		}
		
		return foundNameCustomerList;
	}
}
