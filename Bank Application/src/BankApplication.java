import java.util.Scanner;

public class BankApplication {
	Scanner scan;
	Bank bank;
	private boolean shouldRunAgain = true;

	public static void main(String[] args) {
		BankApplication application = new BankApplication();

		application.runApplication();
	}

	public BankApplication() {
		// CONFIG - START
		scan = new Scanner(System.in);
		// Should be using this according to FAQ
		scan.useDelimiter(System.lineSeparator());
		// CONFIG - END

		bank = new Bank();
	}

	/**
	 * Wrapper for running application(menu and what comes after it)
	 */
	private void runApplication() {
		int menuChoice;
		int accountNr;
		String input;
		double amount;
		do {
			printMenu();
			printAction("val");
			//scan.nextin
			menuChoice = scan.nextInt();

			switch (menuChoice) {
			case 1:
				printAction("id: ");
				long id = scan.nextLong();
				System.out.println(handleFindAccountFromOwner(id));
				break;
			case 2:
				printAction("namn");
				input = scan.next();
				System.out.println(handleSearchAccountOwnerFromPartOfName(input));
				break;
			case 3:
				printAction("konto");
				accountNr = scan.nextInt();
				printAction("belopp");
				amount = scan.nextDouble();
				
				System.out.println(handleDepositMoney(accountNr, amount));
				break;
			case 4:
				printAction("från konto");
				accountNr = scan.nextInt();
				printAction("belopp");
				amount = scan.nextDouble();
				System.out.println(handleWithdrawMoney(accountNr, amount));
				break;
			case 5:
				printAction("från konto: ");
				int fromAccountId = scan.nextInt();

				printAction("till konto");
				int toAccountId = scan.nextInt();

				printAction("belopp");
				amount = scan.nextDouble();
				System.out.println(handleTransfer(fromAccountId, toAccountId, amount));
				break;
			case 6:
				printAction("namn");
				String name = scan.next();

				printAction("id");
				id = scan.nextLong();
				System.out.println(handleCreateAccount(name, id));
				break;
			case 7:
				printAction("konto");
				accountNr = scan.nextInt();
				handleRemoveAccount(accountNr);
				break;
			case 8:
				System.out.println(handlePrintAllAccounts());
				break;
			case 9:
				handleCloseApplication();
				break;
			default:
				System.out.println("Skriv ett tal mellan 0 till 9");
				break;
			}

		}
		// This should run again and again until user closes it.
		while (shouldRunAgain);

	}

	private String handleFindAccountFromOwner(long id) {
		StringBuilder returnString = new StringBuilder();

		for (BankAccount account : bank.findAccountsForHolder(id)) {
			returnString.append(account + "\n");
		}
		return returnString.toString();
	}

	private String handleSearchAccountOwnerFromPartOfName(String name) {
		StringBuilder returnString = new StringBuilder();

		for (Customer customer : bank.findByPartofName(name)) {
			returnString.append(customer + "\n");
		}
		return returnString.toString();
	}

	private double handleDepositMoney(int accountNr, double amount) {
		

		// Search for the account and then deposit the money
		BankAccount account = bank.findByNumber(accountNr);
		account.deposit(amount);

		return amount;
	}

	private BankAccount handleWithdrawMoney(int accountNr, double amount) {
		// Search for the account and then deposit the money
		BankAccount account = bank.findByNumber(accountNr);
		account.withdraw(amount);

		return account;

	}

	private String handleTransfer(int fromAccountId, int toAccountId, double amount) {
		StringBuilder returnString = new StringBuilder();
		
		// Here we transfer the money, it is removed from sender and added to
		// reciever.
		BankAccount fromAccount = bank.findByNumber(fromAccountId);
		BankAccount toAccount = bank.findByNumber(toAccountId);
		fromAccount.withdraw(amount);
		toAccount.deposit(amount);
		returnString.append(fromAccount.toString() + "\n");
		returnString.append(toAccount.toString() + "\n");
		
		return returnString.toString();
	}

	private String handleCreateAccount(String name, long id) {

		int accountId = bank.addAccount(name, id);

		return "konto skapat: " + accountId;

	}

	private void handleRemoveAccount(int accountNr) {
		bank.removeAccount(accountNr);
	}

	private String handlePrintAllAccounts() {
		StringBuilder returnString = new StringBuilder();
		for (BankAccount account : bank.getAllAccounts()) {
			returnString.append(account.toString() + "\n");
		}
		
		return returnString.toString();
	}
	
	private void handleCloseApplication(){
		// When setting this to false, the while loop run runApplication() will not run again. 
		shouldRunAgain = false;
	}

	private void printMenu() {
		System.out.println("------------------ ");
		System.out.println("1. Hitta konto utifrån innehavare" + "\n 2. Sök kontoinnehavare utifrån (del av) namn"
				+ "\n 3. Sätt in" + "\n 4. Ta ut" + "\n 5. Överföring" + "\n 6. Skapa konto" + "\n 7. Ta bort konto"
				+ "\n 8. Skriv ut konton" + "\n 9. Avsluta");
	}

	/**
	 * Prints the action that the user should type in. E.g. if name needs to be
	 * sent in, run printAction("name") The colon will automatically be
	 * inserted.
	 * 
	 * @param action
	 */
	private void printAction(String action) {
		System.out.println(action + ": ");
	}

	/**
	 * Wrapper for next line scan on scanner.
	 * 
	 * @return The input that user sent in.
	 */
	private String scanNextLine() {
		return scan.nextLine().trim();
	}
}
