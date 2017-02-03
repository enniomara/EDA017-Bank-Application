
public class BankAccount {
	/**
	 * Creates a new bank account for a customer with name and id (personnr). A
	 * unique account number and has initially 0 kr.
	 * 
	 * @param holderName
	 *            The account holder's name
	 * @param holderId
	 *            The account holder's id (personnr)
	 */
	public BankAccount(String holderName, long holderId) {

	}

	/**
	 * Create a new bank account for customer. It is given a unique account
	 * number and has initially 0 kr.
	 * 
	 * @param holder
	 *            The Customer object that contains all data a customer has
	 */
	public BankAccount(Customer holder) {

	}

	/**
	 * @return Customer who owns account
	 */
	public Customer getHolder() {
		return null;
	}

	/**
	 * @return Account's unique number
	 */
	public int getAccountNumber() {
		return 0;
	}

	/**
	 * @return Amount left in account. 
	 */
	public double getAmount() {
		return 0;
	}

	/**
	 * Make a monetary deposit to account
	 * @param amount Amount to be added
	 */
	public void deposit(double amount) {

	}

	/**
	 * Withdraw certain amount from account. If amount is larger than the balance, the balance goes negative.
	 * @param amount Amount to be withdrawn
	 */
	public void withdraw(double amount) {

	}

	/**
	 * @return Information that account stores
	 */
	@Override
	public String toString() {
		return null;
	}

}
