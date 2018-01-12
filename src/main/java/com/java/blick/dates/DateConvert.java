package com.java.blick.dates;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Converts different kind of dates in other types
 * 
 * @author Michael Kosin
 *
 */
public class DateConvert {

	public static Dates from(Date date) {
		return new Dates(date);
	}

	public static Instants from(Instant instant) {
		return new Instants(instant);
	}

	public static LocalDates from(LocalDate localDate) {
		return new LocalDates(localDate);
	}

	public static LocalDateTimes from(LocalDateTime localDateTime) {
		return new LocalDateTimes(localDateTime);
	}

	public static Millis from(long millis) {
		return new Millis(millis);
	}

	public static Timestamps from(Timestamp timestamp) {
		return new Timestamps(timestamp);
	}

	public static ZonedDateTimes from(ZonedDateTime zonedDateTime) {
		return new ZonedDateTimes(zonedDateTime);
	}

}
