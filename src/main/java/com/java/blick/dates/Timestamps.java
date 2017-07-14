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
		return new LocalDateTimeFactory(toDate(timestamp));
	}

	public static LocalDateFactory toLocalDate(Timestamp timestamp) {
		Objects.requireNonNull(timestamp);
		return new LocalDateFactory(toDate(timestamp));
	}

	public static LocalTimeFactory toLocalTime(Timestamp timestamp) {
		Objects.requireNonNull(timestamp);
		return new LocalTimeFactory(toDate(timestamp));
	}

	public static Month toMonth(Timestamp timestamp) {
		Objects.requireNonNull(timestamp);
		Calendar calendar = Dates.toCalendar(toDate(timestamp));
		return Month.of(calendar.get(Calendar.MONTH) + 1);
	}

	public static MonthDay toMonthDay(Timestamp timestamp) {
		Objects.requireNonNull(timestamp);
		return MonthDay.from(toDate(timestamp).toInstant());
	}

	public static Year toYear(Timestamp timestamp) {
		Objects.requireNonNull(timestamp);
		Calendar calendar = Dates.toCalendar(toDate(timestamp));
		return Year.of(calendar.get(Calendar.YEAR));
	}

	public static YearMonth toYearMonth(Timestamp timestamp) {
		Objects.requireNonNull(timestamp);
		Date date = toDate(timestamp);
		Calendar calendar = Dates.toCalendar(date);
		return YearMonth.of(calendar.get(Calendar.YEAR), Dates.toMonth(date));
	}

	public static DayOfWeek toDayOfWeek(Timestamp timestamp) {
		Objects.requireNonNull(timestamp);
		return DayOfWeek.from(toDate(timestamp).toInstant());
	}

	public static Calendar toCalendar(Timestamp timestamp) {
		Objects.requireNonNull(timestamp);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(toDate(timestamp));
		return calendar;
	}

	public static ZonedDateTimeFactory toZonedDateTime(Timestamp timestamp) {
		Objects.requireNonNull(timestamp);
		return new ZonedDateTimeFactory(toDate(timestamp));
	}

	public static Instant toInstant(Timestamp timestamp) {
		Objects.requireNonNull(timestamp);
		return timestamp.toInstant();
	}

	public static long toMillis(Timestamp timestamp) {
		return timestamp.getTime();
	}

}
