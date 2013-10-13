package com.chida.denominator.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.chida.denominator.Denominator;

public class TestDenominator {

	@Test
	public void testValidateNUll() {
		Denominator denominator = new Denominator(null);
		boolean isValid = denominator.validateCurrencyAmount();
		assertFalse(isValid);
	}
	
	@Test
	public void testValidateInvalidNumber() {
		Denominator denominator = new Denominator("abcdef");
		boolean isValid = denominator.validateCurrencyAmount();
		assertFalse(isValid);
	}

}
