package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;

public class AccountTests {

	// <action> should <effect> [when <scene>]
	@Test
	public void depositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount() {
		
		// Pattern AAA
		
		// Arrange
		double amount = 200.0;
		double expectedValue = 196.0;
		Account acc = new Account(1L, 0.0);
		
		// Act
		acc.deposit(amount);
		
		// Assert
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
}
