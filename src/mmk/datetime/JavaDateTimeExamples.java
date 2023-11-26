package mmk.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class JavaDateTimeExamples {

	public static void main(String[] args) {
		LocalDateTime dateTime;
		
		dateTime = LocalDateTime.now();
		
		System.out.println(dateTime);
		
		LocalDate date = LocalDate.of(2018, Month.APRIL, 21);
		LocalTime time = LocalTime.of(13, 45);
		
		System.out.println(date);
		System.out.println(time);
		
		dateTime = LocalDateTime.of(date, time);
		
		System.out.println(dateTime);
		
		date = LocalDate.of(2000, Month.NOVEMBER, 20);
		LocalDate nextWed = date.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
		
		System.out.println(nextWed);
	}

}
