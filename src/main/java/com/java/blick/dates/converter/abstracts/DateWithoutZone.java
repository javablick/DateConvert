package com.java.blick.dates.converter.abstracts;

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
import java.util.TimeZone;

import com.java.blick.dates.converter.Calendars;
import com.java.blick.dates.converter.ZonedDateTimes;

public abstract class DateWithoutZone {

	protected abstract long toMillis();

	protected abstract Instant toInstant();

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

	public LocalDateTime toLocalDateTime(ZoneId zone) {
		return toInstant().atZone(zone).toLocalDateTime();
	}

	public LocalDateTime toLocalDateTimeWithDefaultZone() {
		return toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public LocalDate toLocalDate(ZoneId zone) {
		return toLocalDateTime(zone).toLocalDate();
	}

	public LocalDate toLocalDateWithDefaultZone() {
		return toLocalDateTimeWithDefaultZone().toLocalDate();
	}

	public LocalTime toLocalTime(ZoneId zone) {
		return toLocalDateTime(zone).toLocalTime();
	}

	public Calendar toCalendar(ZoneId zone) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setTimeZone(TimeZone.getTimeZone(zone));
		calendar.setTimeInMillis(toMillis());
		return calendar;
	}

	public Calendar toCalendarWithDefaultZone() {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
		calendar.setTimeInMillis(toMillis());
		return calendar;
	}

	public int toDayOfMonth(ZoneId zoneId) {
		return new Calendars(toCalendar(zoneId)).toDayOfMonth();
	}

	public DayOfWeek toDayOfWeek(ZoneId zoneId) {
		return new Calendars(toCalendar(zoneId)).toDayOfWeek();
	}

	public int toDayOfYear(ZoneId zoneId) {
		return new Calendars(toCalendar(zoneId)).toDayOfYear();
	}

	public Month toMonth(ZoneId zoneId) {
		return new Calendars(toCalendar(zoneId)).toMonth();
	}

	public MonthDay toMonthDay(ZoneId zoneId) {
		return new Calendars(toCalendar(zoneId)).toMonthDay();
	}

	public YearMonth toYearMonth(ZoneId zoneId) {
		return new Calendars(toCalendar(zoneId)).toYearMonth();
	}

	public Year toYear(ZoneId zoneId) {
		return new Calendars(toCalendar(zoneId)).toYear();
	}

	public int toDayOfMonthWithDefaultZone() {
		return new Calendars(toCalendarWithDefaultZone()).toDayOfMonth();
	}

	public DayOfWeek toDayOfWeekWithDefaultZone() {
		return new Calendars(toCalendarWithDefaultZone()).toDayOfWeek();
	}

	public int toDayOfYearWithDefaultZone() {
		return new Calendars(toCalendarWithDefaultZone()).toDayOfYear();
	}

	public Month toMonthWithDefaultZone() {
		return new Calendars(toCalendarWithDefaultZone()).toMonth();
	}

	public MonthDay toMonthDayWithDefaultZone() {
		return new Calendars(toCalendarWithDefaultZone()).toMonthDay();
	}

	public YearMonth toYearMonthWithDefaultZone() {
		return new Calendars(toCalendarWithDefaultZone()).toYearMonth();
	}

	public Year toYearWithDefaultZone() {
		return new Calendars(toCalendarWithDefaultZone()).toYear();
	}

}
