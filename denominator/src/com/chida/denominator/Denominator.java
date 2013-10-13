package com.chida.denominator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

import com.chida.denominator.NumberToWords.AbstractProcessor;
import com.chida.denominator.NumberToWords.DefaultProcessor;

public class Denominator {
	
	String inputString;
	public Denominator(String inputString) {
		this.inputString =  inputString;
	}

	public static void main(String[] args) {
		getInputCurrencyAmount();
	}

	private static String getInputCurrencyAmount() {
		System.out.println("Enter the currency value here- Enter E to exit: ");
		String inputString = null;
		try {
			BufferedReader bufferRead = new BufferedReader(
					new InputStreamReader(System.in));
			inputString = bufferRead.readLine();

			System.out.println(inputString);
			
			if(inputString.equals("E")) {
				System.out.println("You have Exited the currency Denominator");
				System.exit(0);
			}
			Denominator denominator = new Denominator (inputString);
			
			boolean isValid = denominator.validateCurrencyAmount();
			if(!isValid) {
				System.out.println("Please enter a valid Currency amount");
				getInputCurrencyAmount();
			} else {
				denominator.printDenomination();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputString;
	}

	public void printDenomination() {
		AbstractProcessor processor = new DefaultProcessor();
        
        String output = processor.getName(this.inputString);
        System.out.println(output);
		
	}



	public  boolean validateCurrencyAmount() {
		if(this.inputString == null) {
			return false;
		} else {
			try {
		BigDecimal value = new BigDecimal(this.inputString);
			System.out.println(value);
			return true;
			} 
			catch (NumberFormatException nfe) {
				return false;
			}
		}
	}
}
