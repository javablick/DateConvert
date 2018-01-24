package com.java.blick.dates.converter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.util.Objects;

public final class LocalDates {

	private LocalDate localDate;

	public LocalDates(LocalDate localDate) {
		Objects.requireNonNull(localDate);
		this.localDate = localDate;
	}

	public LocalDateTimes withStartOfDay() {
		return new LocalDateTimes(localDate.atStartOfDay());
	}

	public LocalDateTimes withLocalTime(LocalTime time) {
		return new LocalDateTimes(localDate.atTime(time));
	}

	public LocalDateTimes withLocalTime(int hour, int minute, int second, int nanoOfSecond) {
		return new LocalDateTimes(localDate.atTime(hour, minute, second, nanoOfSecond));
	}

	public LocalDateTime toLocalDateTimeAtStartOfDay() {
		return withStartOfDay().toLocalDateTime();
	}

	public LocalDateTime toLocalDateTime(LocalTime time) {
		return withLocalTime(time).toLocalDateTime();
	}

	public LocalDateTime toLocalDateTime(int hour, int minute, int second, int nanoOfSecond) {
		return withLocalTime(hour, minute, second, nanoOfSecond).toLocalDateTime();
	}

	public Month toMonth() {
		return localDate.getMonth();
	}

	public MonthDay toMonthDay() {
		return MonthDay.of(toMonth(), localDate.getDayOfMonth());
	}

	public Year toYear() {
		return Year.of(localDate.getYear());
	}

	public YearMonth toYearMonth() {
		return YearMonth.of(localDate.getYear(), localDate.getMonth());
	}

	public DayOfWeek toDayOfWeek() {
		return localDate.getDayOfWeek();
	}

}
