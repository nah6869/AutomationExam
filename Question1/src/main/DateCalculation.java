package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateCalculation {

	public DateCalculation() {

	}

	private DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");

	public long calSumDate(String startDate, String closeDate) {
		LocalDate sdate = LocalDate.parse(startDate, format);
		LocalDate cdate = LocalDate.parse(closeDate, format);
		long days = cdate.toEpochDay() - sdate.toEpochDay() + 1;
		System.out.println(days);
		return days;
	}

	public LocalDate calCloseDate(String startDate, int additionalMonth) {
		LocalDate sdate = LocalDate.parse(startDate, format);
		int day = sdate.getDayOfMonth();
		int monthLength = sdate.lengthOfMonth();
		LocalDate closeDate = sdate.plusMonths(additionalMonth);
		
		//Check if start day is the last day of the month
		if (day == monthLength) {
			int closeDay = closeDate.getDayOfMonth();
			int maxDay = closeDate.lengthOfMonth();
			closeDate = closeDate.plusDays(maxDay - closeDay);
		}
		
		return closeDate;
	}
}
