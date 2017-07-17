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

public final class Millis {

	public static Timestamp toTimestamp(long millis) {
		return new Timestamp(millis);
	}

	public static LocalDateTimeFactory toLocalDateTime(long millis) {
		return new LocalDateTimeFactory(millis);
	}

	public static LocalDateFactory toLocalDate(long millis) {
		return new LocalDateFactory(millis);
	}

	public static LocalTimeFactory toLocalTime(long millis) {
		return new LocalTimeFactory(millis);
	}

	public static Month toMonth(long millis) {
		Calendar calendar = toCalendar(millis);
		return Month.of(calendar.get(Calendar.MONTH) + 1);
	}

	public static MonthDay toMonthDay(long millis) {
		Objects.requireNonNull(millis);
		return MonthDay.from(toInstant(millis));
	}

	public static Year toYear(long millis) {
		Calendar calendar = toCalendar(millis);
		return Year.of(calendar.get(Calendar.YEAR));
	}

	public static YearMonth toYearMonth(long millis) {
		Calendar calendar = toCalendar(millis);
		return YearMonth.of(calendar.get(Calendar.YEAR), toMonth(millis));
	}

	public static DayOfWeek toDayOfWeek(long millis) {
		return DayOfWeek.from(toInstant(millis));
	}

	public static Calendar toCalendar(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar;
	}

	public static ZonedDateTimeFactory toZonedDateTime(long millis) {
		return new ZonedDateTimeFactory(millis);
	}

	public static Instant toInstant(long millis) {
		return Instant.ofEpochMilli(millis);
	}

	public static Date toDate(long millis) {
		return new Date(millis);
	}
	
}
