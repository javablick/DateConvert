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

public class Instants {

	public static Date toDate(Instant instant) {
		Objects.requireNonNull(instant);
		return Date.from(instant);
	}

	public static Timestamp toTimestamp(Instant instant) {
		Objects.requireNonNull(instant);
		return new Timestamp(toMillis(instant));
	}

	public static LocalDateTimeFactory toLocalDateTime(Instant instant) {
		Objects.requireNonNull(instant);
		return new LocalDateTimeFactory(toMillis(instant));
	}

	public static LocalDateFactory toLocalDate(Instant instant) {
		Objects.requireNonNull(instant);
		return new LocalDateFactory(toMillis(instant));
	}

	public static LocalTimeFactory toLocalTime(Instant instant) {
		Objects.requireNonNull(instant);
		return new LocalTimeFactory(toMillis(instant));
	}

	public static Month toMonth(Instant instant) {
		Objects.requireNonNull(instant);
		return Millis.toMonth(toMillis(instant));
	}

	public static MonthDay toMonthDay(Instant instant) {
		Objects.requireNonNull(instant);
		return Millis.toMonthDay(toMillis(instant));
	}

	public static Year toYear(Instant instant) {
		Objects.requireNonNull(instant);
		return Millis.toYear(toMillis(instant));
	}

	public static YearMonth toYearMonth(Instant instant) {
		Objects.requireNonNull(instant);
		return Millis.toYearMonth(toMillis(instant));
	}

	public static DayOfWeek toDayOfWeek(Instant instant) {
		Objects.requireNonNull(instant);
		return Millis.toDayOfWeek(toMillis(instant));
	}

	public static Calendar toCalendar(Instant instant) {
		Objects.requireNonNull(instant);
		return Millis.toCalendar(toMillis(instant));
	}

	public static ZonedDateTimeFactory toZonedDateTime(Instant instant) {
		Objects.requireNonNull(instant);
		return new ZonedDateTimeFactory(toMillis(instant));
	}

	public static long toMillis(Instant instant) {
		return instant.toEpochMilli();
	}

}
