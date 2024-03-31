package com.shoppingcart.maven.classes;

public class Payment {

	private String cardName;
	private String cardNumber;
	private String securityCode;
	private String expirationDate;
	
	public Payment(String cardName, String cardNumber, String securityCode, String expirationDate) {
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.securityCode = securityCode;
		this.expirationDate = expirationDate;
	}
	
	public static String processPayment(double amount, String cardName, String cardNumber, String securityCode, String expirationDate) {
		
		boolean cardCheck = checkCard(cardName, cardNumber, securityCode, expirationDate);
		
		if (cardCheck == true && amount > 0)
	        return "Payment of $" + amount + " processed successfully.";
		else if (cardCheck == true && amount <= 0)
			return "Payment amount is invalid.";
		else
	        return "Payment rejected due to wrong card information.";

	}
	
	public static boolean checkCard(String cardName, String cardNumber, String securityCode, String expirationDate) {
		
		boolean checkName;
		boolean checkNumber;
		boolean checkDate;
		
		checkName = checkCardName(cardName);
			
		checkNumber = checkCardNumberAndSecurity(cardName, cardNumber, securityCode);
		
		checkDate = checkCardDate(expirationDate);
		
		return checkName && checkNumber && checkDate;
		
	}

	private static boolean checkCardNumberAndSecurity(String cardName, String cardNumber, String securityCode){
		
		boolean checkNumberAndSecurity;
		
		if (cardName == "AMEX" && 
			cardNumber.length() == 15 &&
			cardNumber.matches("^[0-9]*$") &&
			securityCode.matches("^[0-9]*$") &&
			securityCode.length() == 4) 
			
			checkNumberAndSecurity = true;
		
		else if ((cardName == "Discover" || 
				cardName == "Visa" ||
				cardName == "MasterCard") &&
				cardNumber.length() == 16 &&
				cardNumber.matches("^[0-9]*$") &&
				securityCode.matches("^[0-9]*$") &&
				securityCode.length() == 3)
			
			checkNumberAndSecurity = true;
		
		else
			
			checkNumberAndSecurity = false;
		
		return checkNumberAndSecurity;
	}

	private static boolean checkCardName(String cardName) {
		
		boolean checkName;
		
		if (cardName == "AMEX" ||
			cardName == "Discover" || 
			cardName == "Visa" ||
			cardName == "MasterCard")
			checkName = true;
		else
			checkName = false;
		
		return checkName;
	}
	
	private static boolean checkCardDate(String expirationDate) {
		//checks that format is mm/yy
		//checks that expiration date is after current month/year
		
		boolean checkDate;
		String pattern = "^(0[1-9]|1[0-2])/([2-9][4-9])$";
		
		if (expirationDate.length() != 5)
			checkDate = false;
		
		else if (expirationDate.matches(pattern)) {
			
			 String[] parts = expirationDate.split("/");
			
			 int month = Integer.parseInt(parts[0]);
		     int year = Integer.parseInt(parts[1]);
		     
		     if (year > 24 || (year == 24 && month > 4)) {
		    	 	checkDate = true;
		     } else {
		         checkDate = false;
		     }}
		     
		else
			checkDate = false;
			
		return checkDate;
		
	}

}
