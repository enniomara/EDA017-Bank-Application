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
		do {
			printMenu();
			printAction("val");
			//scan.nextin
			menuChoice = scan.nextInt();

			switch (menuChoice) {
			case 1:
				handleFindAccountFromOwner();
				break;
			case 2:
				handleSearchAccountOwnerFromPartOfName();
				break;
			case 3:
				handleDepositMoney();
				break;
			case 4:
				handleWithdrawMoney();
				break;
			case 5:
				handleTransfer();
				break;
			case 6:
				handleCreateAccount();
				break;
			case 7:
				handleRemoveAccount();
				break;
			case 8:
				handlePrintAllAccounts();
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

	private void handleFindAccountFromOwner() {
		printAction("id: ");
		long id = scan.nextLong();

		for (BankAccount account : bank.findAccountsForHolder(id)) {
			System.out.println(account);
		}
	}

	private void handleSearchAccountOwnerFromPartOfName() {
		printAction("namn");
		String input = scan.nextLine();

		for (Customer customer : bank.findByPartofName(input)) {
			System.out.println(customer);
		}
	}

	private void handleDepositMoney() {
		printAction("konto");
		int accountNr = scan.nextInt();
		printAction("belopp");
		double amount = scan.nextDouble();

		// Search for the account and then deposit the money
		BankAccount account = bank.findByNumber(accountNr);
		account.deposit(amount);

		System.out.println(amount);
	}

	private void handleWithdrawMoney() {
		printAction("från konto");
		int accountNr = scan.nextInt();
		printAction("belopp");
		double amount = scan.nextDouble();

		// Search for the account and then deposit the money
		BankAccount account = bank.findByNumber(accountNr);
		account.withdraw(amount);

		System.out.println(account);

	}

	private void handleTransfer() {
		printAction("från konto: ");
		int fromAccountId = scan.nextInt();

		printAction("till konto");
		int toAccountId = scan.nextInt();

		printAction("belopp");
		double amount = scan.nextDouble();

		// Here we transfer the money, it is removed from sender and added to
		// reciever.
		BankAccount fromAccount = bank.findByNumber(fromAccountId);
		BankAccount toAccount = bank.findByNumber(toAccountId);
		fromAccount.withdraw(amount);
		toAccount.deposit(amount);
		System.out.println(fromAccount);
		System.out.println(toAccount);
	}

	private void handleCreateAccount() {
		printAction("namn");
		String name = scan.nextLine();

		printAction("id");
		long id = scan.nextLong();

		int accountId = bank.addAccount(name, id);

		System.out.println("konto skapat: " + accountId);

	}

	private void handleRemoveAccount() {
		printAction("konto");
		int accountNr = scan.nextInt();

		bank.removeAccount(accountNr);
	}

	private void handlePrintAllAccounts() {
		for (BankAccount account : bank.getAllAccounts()) {
			System.out.println(account);
		}
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
