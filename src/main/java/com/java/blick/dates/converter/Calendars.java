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

public final class Calendars {

	private Calendar calendar;

	public Calendars(Calendar calendar) {
		Objects.requireNonNull(calendar);
		this.calendar = calendar;
	}

	public Date toDate() {
		return calendar.getTime();
	}

	public Timestamp toTimestamp() {
		return new Timestamp(toMillis());
	}

	public LocalDateTime toLocalDateTime() {
		return toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public LocalDate toLocalDate() {
		return toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public LocalTime toLocalTime() {
		return toLocalDateTime().toLocalTime();
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

	public ZonedDateTimes withZone(ZoneId zone) {
		return new ZonedDateTimes(ZonedDateTime.ofInstant(toInstant(), zone));
	}

	public ZonedDateTimes withDefaultZone() {
		return withZone(ZoneId.systemDefault());
	}

	public ZonedDateTime toZonedDateTime(ZoneId zone) {
		return withZone(zone).toZonedDateTime();
	}

	public ZonedDateTime toZonedDateTimeWithDefaultZone() {
		return withZone(ZoneId.systemDefault()).toZonedDateTime();
	}

	public Instant toInstant() {
		return toDate().toInstant();
	}

	public long toMillis() {
		return calendar.getTimeInMillis();
	}
}
