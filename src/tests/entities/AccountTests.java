package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {

	// <action> should <effect> [when <scene>]
	@Test
	public void depositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount() {
		
		// Pattern AAA
		
		// Arrange
		double amount = 200.0;
		double expectedValue = 196.0;
		Account acc = AccountFactory.createEmptyAccount();
		
		// Act
		acc.deposit(amount);
		
		// Assert
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {
		
		double expectedValue = 100.0;
		Account acc = AccountFactory.createAccount(expectedValue);
		double amount = -200.0;
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}

	@Test
	public void fullWithDrawShouldClearBalance() {
		// We do not put "when" because there's only one scenario in this case.
		
		double expectedValue = 0.0;
		double initialBalance = 899.21;
		Account acc = AccountFactory.createAccount(initialBalance);
		
		double result = acc.fullWithdraw();
		
		// You can have as many assertions as you want
		Assertions.assertTrue(expectedValue == acc.getBalance());
		Assertions.assertEquals(result, initialBalance);
	}

	@Test
	public void withdrawShouldDecreaseAmountWhenSufficientBalance() {
		//it's a good practice to test every scenario
		
		Account acc = AccountFactory.createAccount(800.0);
		
		acc.withdraw(500.0);
		
		Assertions.assertEquals(300.0, acc.getBalance());
	}
	
	@Test
	public void withdrawShouldThrowExceptionWhenInsufficientBalance() {	
		//in junit 5 the process to work with exceptions:
		// 1a param: exception that is expected to be thrown
		// 2a param: lambda expresion that will cause the exception
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Account acc = AccountFactory.createAccount(800.0);
			acc.withdraw(800.000001);
		});
	}
	
}
