package com.java.blick.dates.converter;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public final class Dates {

	private Date date;

	public Dates(Date date) {
		Objects.requireNonNull(date);
		this.date = date;
	}

	public Timestamp toTimestamp() {
		return new Timestamp(date.getTime());
	}

	public Month toMonth() {
		return new Millis(toMillis()).toMonth();
	}

	public MonthDay toMonthDay() {
		return new Millis(toMillis()).toMonthDay();
	}

	public Year toYear() {
		return new Millis(toMillis()).toYear();
	}

	public YearMonth toYearMonth() {
		return new Millis(toMillis()).toYearMonth();
	}

	public DayOfWeek toDayOfWeek() {
		return new Millis(toMillis()).toDayOfWeek();
	}

	public Calendar toCalendar() {
		return new Millis(toMillis()).toCalendar();
	}

	public ZonedDateTime toZonedDateTime(ZoneId zone) {
		return ZonedDateTime.ofInstant(toInstant(), zone);
	}

	public ZonedDateTime toZonedDateTime() {
		return toZonedDateTime(ZoneId.systemDefault());
	}

	public ZonedDateTimes withZone(ZoneId zone) {
		return new ZonedDateTimes(ZonedDateTime.ofInstant(toInstant(), zone));
	}

	public ZonedDateTimes withDefaultZone() {
		return new ZonedDateTimes(toZonedDateTime(ZoneId.systemDefault()));
	}

	public Instant toInstant() {
		return date.toInstant();
	}

	public long toMillis() {
		return date.getTime();
	}
}
