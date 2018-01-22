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

public class Timestamps {

	private Timestamp timestamp;

	public Timestamps(Timestamp timestamp) {
		Objects.requireNonNull(timestamp);
		this.timestamp = timestamp;
	}

	public Date toDate() {
		return new Date(timestamp.getTime());
	}

	public LocalDateTime toLocalDateTime() {
		return toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public LocalDate toLocalDate() {
		return toLocalDateTime().toLocalDate();
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

	public ZonedDateTime withZone(ZoneId zone) {
		return ZonedDateTime.ofInstant(toInstant(), zone);
	}

	public ZonedDateTime withDefaultZone() {
		return withZone(ZoneId.systemDefault());
	}

	public Instant toInstant() {
		return timestamp.toInstant();
	}

	public long toMillis() {
		return timestamp.getTime();
	}

}
