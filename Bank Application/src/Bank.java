import java.util.ArrayList;

public class Bank {
	/**
	 * Create an empty bank.
	 */
	public Bank() {

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
		return 0;
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
		return false;
	}

	/**
	 * Get a list of all account currently in the bank. The list is sorted by
	 * holder name.
	 * 
	 * @return List containing all accounts in bank.
	 */
	public ArrayList<BankAccount> getAllAccounts() {
		return null;
	}

	/**
	 * Find a specific bank account given its number (unique identifier).
	 * 
	 * @param accountNumber
	 *            Account number
	 * @return The bank account if found, otherwise null.
	 */
	public BankAccount findByNumber(int accountNumber) {
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
		return null;
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
		return null;
	}
}
