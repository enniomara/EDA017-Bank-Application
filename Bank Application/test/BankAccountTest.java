import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {

	@Test
	public void testDeposit() {
		BankAccount test = new BankAccount("Jane Smith", 2558324);
		double amount = 0;

		test.deposit(22.0);
		amount += 22.0;

		assertTrue(amount == test.getAmount());

		test.deposit(50.0);
		amount += 50.0;
		assertTrue(amount == test.getAmount());
	}

	@Test
	public void testWithdraw() {
		BankAccount test = new BankAccount("Jane Smith", 2558324);
		double amount = 100.0;
		test.deposit(amount);

		test.withdraw(21);
		amount -= 21;
		assertTrue(amount == test.getAmount());

		// This brings the amount to -1
		test.withdraw(80.0);
		amount -= 80;
		assertTrue(amount == test.getAmount());
	}

}
