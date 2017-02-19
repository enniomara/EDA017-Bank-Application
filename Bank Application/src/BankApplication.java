import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

import javax.xml.bind.ValidationEvent;

public class BankApplication {
	Scanner scan;

	public static void main(String[] args) {
		BankApplication application = new BankApplication();
		application.runApplication();
	}

	public BankApplication() {
		// CONFIG - START
		Scanner scan = new Scanner(System.in);
		// Should be using this according to FAQ
		scan.useDelimiter(System.lineSeparator());
		// CONFIG - END
	}

	/**
	 * Wrapper for running application(menu and what comes after it)
	 */
	private void runApplication() {
		int menuChoice;
		boolean runAgain = true;
		do {
			printMenu();
			printAction("val");
			menuChoice = scan.nextInt();

			switch (menuChoice) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			case 0:
				break;
			default:
				System.out.println("Skriv ett tal mellan 0 till 9");
				break;
			}

		}
		// This should run again and again until user closes it. 
		while (runAgain);

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
