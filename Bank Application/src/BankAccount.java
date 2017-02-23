
public class BankAccount {
	private static int latestAid = 0;

	private BankAccount bankAccount;
	private int aid;

	private Customer accountOwner;

	private String holderName;
	private long holderId;

	private double accountAmount = 0;

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

		accountOwner = new Customer(holderName, holderId);
		this.aid = ++latestAid;
		
	}

	/**
	 * Create a new bank account for customer. It is given a unique account
	 * number and has initially 0 kr.
	 * 
	 * @param holder
	 *            The Customer object that contains all data a customer has
	 */
	public BankAccount(Customer holder) {
		accountOwner = holder;
		this.aid = ++latestAid;
	}

	/**
	 * @return Customer who owns account
	 */
	public Customer getHolder() {
		return accountOwner;
	}

	/**
	 * @return Account's unique number
	 */
	public int getAccountNumber() {
		return aid;
	}

	/**
	 * @return Amount left in account.
	 */
	public double getAmount() {
		return accountAmount;
	}

	/**
	 * Make a monetary deposit to account
	 * 
	 * @param amount
	 *            Amount to be added
	 */
	public void deposit(double amount) {
		accountAmount += amount;
	}

	/**
	 * Withdraw certain amount from account. If amount is larger than the
	 * balance, the balance goes negative.
	 * 
	 * @param amount
	 *            Amount to be withdrawn
	 */
	public void withdraw(double amount) {
		accountAmount -= amount;
	}

	/**
	 * @return Information that account stores
	 */
	@Override
	public String toString() {
		return "konto " + getAccountNumber() + accountOwner.toString() + ": " + accountAmount;
	}

}
