
/**
 * Creates a customer with name
 *
 */
public class Customer {
	private static int latestUid = 0;

	private String name;
	private long idNr;
	private int uid;

	/**
	 * Create a customer with a name and ID. The user is also given a unique
	 * customerNr (uid)
	 * 
	 * @param name
	 *            The name of the customer (e.g. Jane Smith)
	 * @param idNr
	 *            The id of user (personnr)
	 */
	public Customer(String name, long idNr) {
		this.name = name;
		this.idNr = idNr;
		this.uid = ++latestUid;
	}

	/**
	 * @return The customer's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return The customer's id (personnr)
	 */
	public long getIdNr() {
		return idNr;
	}

	/**
	 * @return The customer's unique number
	 */
	public int getCustomerNr() {
		return uid;
	}

	/**
	 * Returns a description of user (e.g. customerNr, name & idNr)
	 */
	@Override
	public String toString() {
		return " (" + getName() + ", id " + getIdNr() + ", kundnr: " + getCustomerNr() + ")";
	}
}
