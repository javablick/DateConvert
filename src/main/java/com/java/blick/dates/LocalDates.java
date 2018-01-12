package com.java.blick.dates;

import java.time.DayOfWeek;
import java.time.LocalDate;
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

	public LocalDateTimes atStartOfDay() {
		return new LocalDateTimes(localDate.atStartOfDay());
	}

	public LocalDateTimes atLocalTime(LocalTime time) {
		return new LocalDateTimes(localDate.atTime(time));
	}

	public LocalDateTimes atLocalTime(int hour, int minute, int second) {
		return new LocalDateTimes(localDate.atTime(hour, minute, second));
	}

	public LocalDateTimes atLocalTime(int hour, int minute, int second, int nanoOfSecond) {
		return new LocalDateTimes(localDate.atTime(hour, minute, second, nanoOfSecond));
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
