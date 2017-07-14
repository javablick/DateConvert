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

public class Dates {

	public static Timestamp toTimestamp(Date date) {
		Objects.requireNonNull(date);
		return new Timestamp(date.getTime());
	}

	public static LocalDateTimeFactory toLocalDateTime(Date date) {
		Objects.requireNonNull(date);
		return new LocalDateTimeFactory(date);
	}

	public static LocalDateFactory toLocalDate(Date date) {
		Objects.requireNonNull(date);
		return new LocalDateFactory(date);
	}

	public static LocalTimeFactory toLocalTime(Date date) {
		Objects.requireNonNull(date);
		return new LocalTimeFactory(date);
	}

	public static Month toMonth(Date date) {
		Objects.requireNonNull(date);
		Calendar calendar = toCalendar(date);
		return Month.of(calendar.get(Calendar.MONTH) + 1);
	}

	public static MonthDay toMonthDay(Date date) {
		Objects.requireNonNull(date);
		return MonthDay.from(date.toInstant());
	}

	public static Year toYear(Date date) {
		Objects.requireNonNull(date);
		Calendar calendar = toCalendar(date);
		return Year.of(calendar.get(Calendar.YEAR));
	}

	public static YearMonth toYearMonth(Date date) {
		Objects.requireNonNull(date);
		Calendar calendar = toCalendar(date);
		return YearMonth.of(calendar.get(Calendar.YEAR), toMonth(date));
	}

	public static DayOfWeek toDayOfWeek(Date date) {
		Objects.requireNonNull(date);
		return DayOfWeek.from(date.toInstant());
	}

	public static Calendar toCalendar(Date date) {
		Objects.requireNonNull(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	public static ZonedDateTimeFactory toZonedDateTime(Date date) {
		Objects.requireNonNull(date);
		return new ZonedDateTimeFactory(date);
	}

	public static Instant toInstant(Date date) {
		Objects.requireNonNull(date);
		return date.toInstant();
	}

	public static long toMillis(Date date) {
		return date.getTime();
	}
}
