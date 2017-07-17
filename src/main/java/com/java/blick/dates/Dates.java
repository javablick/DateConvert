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

public final class Dates {

	public static Timestamp toTimestamp(Date date) {
		Objects.requireNonNull(date);
		return new Timestamp(date.getTime());
	}

	public static LocalDateTimeFactory toLocalDateTime(Date date) {
		Objects.requireNonNull(date);
		return new LocalDateTimeFactory(toMillis(date));
	}

	public static LocalDateFactory toLocalDate(Date date) {
		Objects.requireNonNull(date);
		return new LocalDateFactory(toMillis(date));
	}

	public static LocalTimeFactory toLocalTime(Date date) {
		Objects.requireNonNull(date);
		return new LocalTimeFactory(toMillis(date));
	}

	public static Month toMonth(Date date) {
		Objects.requireNonNull(date);
		return Millis.toMonth(toMillis(date));
	}

	public static MonthDay toMonthDay(Date date) {
		Objects.requireNonNull(date);
		return Millis.toMonthDay(toMillis(date));
	}

	public static Year toYear(Date date) {
		Objects.requireNonNull(date);
		return Millis.toYear(toMillis(date));
	}

	public static YearMonth toYearMonth(Date date) {
		Objects.requireNonNull(date);
		return Millis.toYearMonth(toMillis(date));
	}

	public static DayOfWeek toDayOfWeek(Date date) {
		Objects.requireNonNull(date);
		return Millis.toDayOfWeek(toMillis(date));
	}

	public static Calendar toCalendar(Date date) {
		Objects.requireNonNull(date);
		return Millis.toCalendar(toMillis(date));
	}

	public static ZonedDateTimeFactory toZonedDateTime(Date date) {
		Objects.requireNonNull(date);
		return new ZonedDateTimeFactory(toMillis(date));
	}

	public static Instant toInstant(Date date) {
		Objects.requireNonNull(date);
		return date.toInstant();
	}

	public static long toMillis(Date date) {
		return date.getTime();
	}
}
