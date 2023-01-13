package main;

import main.DateCalculation;

public class Main {

	public static void main(String[] args) {
		String startDate = "20170228";
		String closeDate = "20211224";
		int additionalMonth = 1;
		DateCalculation cal = new DateCalculation();
		cal.calSumDate(startDate, closeDate);
		cal.calCloseDate(startDate, additionalMonth);
	}

}
