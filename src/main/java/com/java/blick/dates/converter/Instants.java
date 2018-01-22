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

public class Instants {

	private Instant instant;

	public Instants(Instant instant) {
		Objects.requireNonNull(instant);
		this.instant = instant;
	}

	public Date toDate() {
		return Date.from(instant);
	}

	public Timestamp toTimestamp() {
		return new Timestamp(toMillis());
	}

	public LocalDateTime toLocalDateTime() {
		return instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
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

	public ZonedDateTime toZonedDateTimeWithZone(ZoneId zone) {
		return ZonedDateTime.ofInstant(instant, zone);
	}

	public ZonedDateTime toZonedDateTimeWithDefaultZone() {
		return toZonedDateTimeWithZone(ZoneId.systemDefault());
	}

	public long toMillis() {
		return instant.toEpochMilli();
	}

}
