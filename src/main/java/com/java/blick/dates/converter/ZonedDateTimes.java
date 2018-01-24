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
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class ZonedDateTimes {

	private ZonedDateTime zonedDateTime;

	public ZonedDateTimes(ZonedDateTime zonedDateTime) {
		Objects.requireNonNull(zonedDateTime);
		this.zonedDateTime = zonedDateTime;
	}

	public ZonedDateTime toZonedDateTime() {
		return zonedDateTime;
	}

	public Date toDate() {
		return new Date(toMillis());

	}

	public Timestamp toTimestamp() {
		return new Timestamp(toMillis());
	}

	public LocalDateTime toLocalDateTime() {
		return zonedDateTime.toLocalDateTime();
	}

	public LocalDate toLocalDate() {
		return zonedDateTime.toLocalDate();
	}

	public LocalTime toLocalTime() {
		return zonedDateTime.toLocalTime();
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

	public Instant toInstant() {
		return zonedDateTime.toInstant();
	}

	public long toMillis() {
		return toInstant().toEpochMilli();
	}

}
