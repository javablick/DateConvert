package com.java.blick.dates.converter.abstracts;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.util.Calendar;

public abstract class DateWithZone {

	protected abstract Calendar toCalendar();

	protected abstract ZonedDateTime toZonedDateTime();

	public LocalDateTime toLocalDateTime() {
		return toZonedDateTime().toLocalDateTime();
	}

	public LocalDate toLocalDate() {
		return toLocalDateTime().toLocalDate();
	}

	public LocalTime toLocalTime() {
		return toLocalDateTime().toLocalTime();
	}

	public int toDayOfMonth() {
		return toCalendar().get(Calendar.DAY_OF_MONTH);
	}

	public DayOfWeek toDayOfWeek() {
		return DayOfWeek.of((toCalendar().get(Calendar.DAY_OF_WEEK) + 5) % 7 + 1);
	}

	public int toDayOfYear() {
		return toCalendar().get(Calendar.DAY_OF_YEAR);
	}

	public Month toMonth() {
		return Month.of(toCalendar().get(Calendar.MONTH) + 1);
	}

	public MonthDay toMonthDay() {
		return MonthDay.of(toMonth().getValue(), toCalendar().get(Calendar.DAY_OF_MONTH));
	}

	public YearMonth toYearMonth() {
		return YearMonth.of(toYear().getValue(), toMonth());
	}

	public Year toYear() {
		return Year.of(toCalendar().get(Calendar.YEAR));
	}

}
