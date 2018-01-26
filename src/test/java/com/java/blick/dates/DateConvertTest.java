package com.java.blick.dates;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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
import java.util.TimeZone;

import org.junit.Test;

import com.java.blick.dates.converter.Dates;

public class DateConvertTest {

	private Date date;
	private Instant instant;
	private Calendar calendar;
	private LocalDate localDate;
	private LocalDateTime localDateTime;
	private ZonedDateTime zonedDateTime;
	private long millis = 0;
	private Timestamp timestamp;

	@Test
	public void converting_from_to_date() {
		calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(2018, 0, 1, 12, 30);
		calendar.setTimeZone(TimeZone.getDefault());
		date = calendar.getTime();

		instant = DateConvert.from(date).toInstant();
		assertThat(DateConvert.from(instant).toDate(), is(date));

		calendar = DateConvert.from(date).toCalendarWithDefaultZone();
		assertThat(DateConvert.from(calendar).toDate(), is(date));

		localDate = DateConvert.from(date).withDefaultZone().toLocalDate();
		assertThat(DateConvert.from(localDate).withLocalTime(12, 30, 0, 0).withDefaultZoneId().toDate(), is(date));

		localDateTime = DateConvert.from(date).withDefaultZone().toLocalDateTime();
		assertThat(DateConvert.from(localDateTime).withDefaultZoneId().toDate(), is(date));

		zonedDateTime = DateConvert.from(date).toZonedDateTimeWithDefaultZone();
		assertThat(DateConvert.from(zonedDateTime).toDate(), is(date));

		millis = DateConvert.from(date).toMillis();
		assertThat(DateConvert.from(millis).toDate(), is(date));

		timestamp = DateConvert.from(date).toTimestamp();
		assertThat(DateConvert.from(timestamp).toDate(), is(date));

	}

	@Test
	public void test_dates_without_zone_methods() {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(2018, 0, 1, 8, 30);
		cal.setTimeZone(TimeZone.getDefault());
		date = cal.getTime();

		Dates dates = DateConvert.from(date);

		assertThat(dates.toYearWithDefaultZone(), is(Year.of(2018)));
		assertThat(dates.toYearMonthWithDefaultZone(), is(YearMonth.of(2018, 1)));

		assertThat(dates.toMonthWithDefaultZone(), is(Month.of(1)));
		assertThat(dates.toMonthDayWithDefaultZone(), is(MonthDay.of(1, 1)));

		assertThat(dates.toDayOfWeekWithDefaultZone(), is(DayOfWeek.of(1)));
		assertThat(dates.toDayOfMonthWithDefaultZone(), is(1));
		assertThat(dates.toDayOfYearWithDefaultZone(), is(1));

		ZoneId zoneId = ZoneId.of("-10");

		assertThat(dates.toYear(zoneId), is(Year.of(2017)));
		assertThat(dates.toYearMonth(zoneId), is(YearMonth.of(2017, 12)));

		assertThat(dates.toMonth(zoneId), is(Month.of(12)));
		assertThat(dates.toMonthDay(zoneId), is(MonthDay.of(12, 31)));

		assertThat(dates.toDayOfWeek(zoneId), is(DayOfWeek.of(7)));
		assertThat(dates.toDayOfMonth(zoneId), is(31));
		assertThat(dates.toDayOfYear(zoneId), is(365));

		cal = Calendar.getInstance();
		cal.clear();
		cal.set(2017, 11, 31, 21, 30);
		cal.setTimeZone(TimeZone.getTimeZone(zoneId));

		assertThat(dates.toLocalDateTime(zoneId), is(DateConvert.from(cal).toLocalDateTime()));
		assertThat(dates.toLocalDate(zoneId), is(DateConvert.from(cal).toLocalDate()));
		assertThat(dates.toLocalTime(zoneId), is(DateConvert.from(cal).toLocalTime()));

	}

	@Test
	public void converting_from_to_calendar() {
		calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(2018, 1, 1, 12, 30);
		calendar.setTimeZone(TimeZone.getDefault());

		date = DateConvert.from(calendar).toDate();
		assertThat(DateConvert.from(date).toCalendarWithDefaultZone(), is(calendar));

		instant = DateConvert.from(calendar).toInstant();
		assertThat(DateConvert.from(instant).toCalendarWithDefaultZone(), is(calendar));

		localDate = DateConvert.from(calendar).toLocalDate();
		assertThat(DateConvert.from(localDate).withLocalTime(12, 30, 0, 0).withDefaultZoneId().toCalendar(),
				is(calendar));

		localDateTime = DateConvert.from(calendar).toLocalDateTime();
		assertThat(DateConvert.from(localDate).withLocalTime(12, 30, 0, 0).withDefaultZoneId().toCalendar(),
				is(calendar));

		zonedDateTime = DateConvert.from(calendar).toZonedDateTime();
		assertThat(DateConvert.from(zonedDateTime).toCalendar(), is(calendar));

		millis = DateConvert.from(calendar).toMillis();
		assertThat(DateConvert.from(millis).toCalendarWithDefaultZone(), is(calendar));

		timestamp = DateConvert.from(calendar).toTimestamp();
		assertThat(DateConvert.from(timestamp).toCalendarWithDefaultZone(), is(calendar));
	}

	@Test
	public void converting_from_to_instant() {
		calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(2018, 1, 1, 10, 15);
		calendar.setTimeZone(TimeZone.getDefault());
		instant = calendar.getTime().toInstant();

		date = DateConvert.from(instant).toDate();
		assertThat(DateConvert.from(date).toInstant(), is(instant));

		calendar = DateConvert.from(instant).toCalendarWithDefaultZone();
		assertThat(DateConvert.from(calendar).toInstant(), is(instant));

		localDate = DateConvert.from(instant).toLocalDateWithDefaultZone();
		assertThat(DateConvert.from(localDate).withLocalTime(10, 15, 0, 0).withDefaultZoneId().toInstant(),
				is(instant));

		localDateTime = DateConvert.from(instant).toLocalDateTimeWithDefaultZone();
		assertThat(DateConvert.from(localDate).withLocalTime(10, 15, 0, 0).withDefaultZoneId().toInstant(),
				is(instant));

		zonedDateTime = DateConvert.from(instant).toZonedDateTimeWithDefaultZone();
		assertThat(DateConvert.from(zonedDateTime).toInstant(), is(instant));

		millis = DateConvert.from(instant).toMillis();
		assertThat(DateConvert.from(millis).toInstant(), is(instant));

		timestamp = DateConvert.from(instant).toTimestamp();
		assertThat(DateConvert.from(timestamp).toInstant(), is(instant));
	}

	@Test
	public void converting_from_to_zonedDateTime() {
		calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(2018, 1, 1, 10, 15);
		calendar.setTimeZone(TimeZone.getDefault());
		instant = calendar.getTime().toInstant();
		zonedDateTime = ZonedDateTime.ofInstant(instant, TimeZone.getDefault().toZoneId());

		timestamp = DateConvert.from(zonedDateTime).toTimestamp();
		assertThat(DateConvert.from(timestamp).toZonedDateTimeWithDefaultZone(), is(zonedDateTime));
	}

	@Test
	public void converting_from_to_millis() {
		calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(2018, 1, 1, 10, 15);
		calendar.setTimeZone(TimeZone.getDefault());
		millis = calendar.getTimeInMillis();

		timestamp = DateConvert.from(millis).toTimestamp();
		assertThat(DateConvert.from(timestamp).toMillis(), is(millis));
	}

	@Test
	public void converting_from_to_localDateTime() {
		localDateTime = LocalDateTime.of(2018, 1, 1, 10, 15);
		ZoneId zoneId = ZoneId.of("-10");
		
		zonedDateTime = DateConvert.from(localDateTime).toZonedDateTimeWithDefaultZone();
		assertThat(DateConvert.from(zonedDateTime).toLocalDateTime(), is(localDateTime));

		zonedDateTime = DateConvert.from(localDateTime).toZonedDateTime(zoneId);
		assertThat(DateConvert.from(zonedDateTime).toLocalDateTime(), is(localDateTime));

		localDate = DateConvert.from(localDateTime).toLocalDate();
		assertThat(DateConvert.from(localDate).toLocalDateTime(10, 15, 0, 0), is(localDateTime));
		assertThat(DateConvert.from(localDate).toLocalDateTime(LocalTime.of(10, 15)), is(localDateTime));

		assertThat(DateConvert.from(localDateTime).toLocalTime(), is(LocalTime.of(10, 15)));
	}

	@Test
	public void converting_from_to_localDate() {
		localDate = LocalDate.of(2018, 1, 1);

		localDateTime = DateConvert.from(localDate).toLocalDateTimeAtStartOfDay();
		assertThat(localDateTime, is(LocalDateTime.of(localDate, LocalTime.of(0, 0))));

		localDateTime = DateConvert.from(localDate).withStartOfDay().toLocalDateTime();
		assertThat(localDateTime, is(LocalDateTime.of(localDate, LocalTime.of(0, 0))));
	}

}
