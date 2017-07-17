package com.java.blick.dates;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import com.java.blick.dates.factories.LocalDateFactory;
import com.java.blick.dates.factories.LocalDateTimeFactory;
import com.java.blick.dates.factories.LocalTimeFactory;
import com.java.blick.dates.factories.ZonedDateTimeFactory;

public class Timestamps {

	public static Date toDate(Timestamp timestamp) {
		Objects.requireNonNull(timestamp);
		return new Date(timestamp.getTime());
	}

	public static LocalDateTimeFactory toLocalDateTime(Timestamp timestamp) {
		Objects.requireNonNull(timestamp);
		return new LocalDateTimeFactory(toMillis(timestamp));
	}

	public static LocalDateFactory toLocalDate(Timestamp timestamp) {
		Objects.requireNonNull(timestamp);
		return new LocalDateFactory(toMillis(timestamp));
	}

	public static LocalTimeFactory toLocalTime(Timestamp timestamp) {
		Objects.requireNonNull(timestamp);
		return new LocalTimeFactory(toMillis(timestamp));
	}

	public static Month toMonth(Timestamp timestamp) {
		Objects.requireNonNull(timestamp);
		return Millis.toMonth(toMillis(timestamp));
	}

	public static MonthDay toMonthDay(Timestamp timestamp) {
		Objects.requireNonNull(timestamp);
		return Millis.toMonthDay(toMillis(timestamp));
	}

	public static Year toYear(Timestamp timestamp) {
		Objects.requireNonNull(timestamp);
		return Millis.toYear(toMillis(timestamp));
	}

	public static YearMonth toYearMonth(Timestamp timestamp) {
		Objects.requireNonNull(timestamp);
		return Millis.toYearMonth(toMillis(timestamp));
	}

	public static DayOfWeek toDayOfWeek(Timestamp timestamp) {
		Objects.requireNonNull(timestamp);
		return Millis.toDayOfWeek(toMillis(timestamp));
	}

	public static Calendar toCalendar(Timestamp timestamp) {
		Objects.requireNonNull(timestamp);
		return Millis.toCalendar(toMillis(timestamp));
	}

	public static ZonedDateTimeFactory toZonedDateTime(Timestamp timestamp) {
		Objects.requireNonNull(timestamp);
		return new ZonedDateTimeFactory(toMillis(timestamp));
	}

	public static Instant toInstant(Timestamp timestamp) {
		Objects.requireNonNull(timestamp);
		return timestamp.toInstant();
	}

	public static long toMillis(Timestamp timestamp) {
		return timestamp.getTime();
	}

}
