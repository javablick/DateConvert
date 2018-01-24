package com.java.blick.dates.converter;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public final class Millis {

	private long millis;

	public Millis(long millis) {
		this.millis = millis;
	}

	public Timestamp toTimestamp() {
		return new Timestamp(millis);
	}

	public LocalDateTime toLocalDateTime() {
		return Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public LocalDate toLocalDate() {
		return toLocalDateTime().toLocalDate();
	}

	public LocalTime toLocalTime() {
		return toLocalDateTime().toLocalTime();
	}

	public Month toMonth() {
		Calendar calendar = toCalendar();
		return Month.of(calendar.get(Calendar.MONTH) + 1);
	}

	public MonthDay toMonthDay() {
		Objects.requireNonNull(millis);
		return MonthDay.from(toInstant());
	}

	public Year toYear() {
		Calendar calendar = toCalendar();
		return Year.of(calendar.get(Calendar.YEAR));
	}

	public YearMonth toYearMonth() {
		Calendar calendar = toCalendar();
		return YearMonth.of(calendar.get(Calendar.YEAR), toMonth());
	}

	public DayOfWeek toDayOfWeek() {
		return DayOfWeek.from(toInstant());
	}

	public Calendar toCalendar() {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setTimeInMillis(millis);
		return calendar;
	}

	public ZonedDateTimes withZone(ZoneId zone) {
		return new ZonedDateTimes(ZonedDateTime.ofInstant(toInstant(), zone));
	}

	public ZonedDateTimes withDefaultZone() {
		return withZone(ZoneId.systemDefault());
	}

	public ZonedDateTime toZonedDateTime(ZoneId zone) {
		return ZonedDateTime.ofInstant(toInstant(), zone);
	}

	public ZonedDateTime toZonedDateTimeWithDefaultZone() {
		return toZonedDateTime(ZoneId.systemDefault());
	}

	public Instant toInstant() {
		return Instant.ofEpochMilli(millis);
	}

	public Date toDate() {
		return new Date(millis);
	}
	
}
