package com.java.blick.dates;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

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
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(2018, 1, 1, 12, 30);
		date = cal.getTime();
				
		instant = DateConvert.from(date).toInstant();
		assertThat(DateConvert.from(instant).toDate(), is(date));

		calendar = DateConvert.from(date).toCalendar();
		assertThat(DateConvert.from(calendar).toDate(), is(date));
		
		localDate = DateConvert.from(date).withDefaultZone().toLocalDate();
		assertThat(DateConvert.from(localDate).withLocalTime(12, 30, 0, 0).withDefaultZoneId().toDate(), is(date));

		localDateTime = DateConvert.from(date).withDefaultZone().toLocalDateTime();
		assertThat(DateConvert.from(localDateTime).withDefaultZoneId().toDate(), is(date));

		zonedDateTime = DateConvert.from(date).toZonedDateTime();
		assertThat(DateConvert.from(zonedDateTime).toDate(), is(date));

		millis = DateConvert.from(date).toMillis();
		assertThat(DateConvert.from(millis).toDate(), is(date));

		timestamp = DateConvert.from(date).toTimestamp();
		assertThat(DateConvert.from(timestamp).toDate(), is(date));

		assertThat(DateConvert.from(date).toYear(), is(Year.of(2018)));
		assertThat(DateConvert.from(date).toMonth(), is(Month.of(2)));
		assertThat(DateConvert.from(date).toMonthDay(), is(MonthDay.of(1, 1)));
		assertThat(DateConvert.from(date).toDayOfWeek(), is(DayOfWeek.of(1)));
	}

	@Test
	public void converting_from_to_calendar() {
		calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(2018, 1, 1, 12, 30);

		date = DateConvert.from(calendar).toDate();
		assertThat(DateConvert.from(date).toCalendar(), is(calendar));

		instant = DateConvert.from(calendar).toInstant();
		assertThat(DateConvert.from(instant).toCalendar(), is(calendar));

		localDate = DateConvert.from(calendar).toLocalDate();
		assertThat(DateConvert.from(localDate).withLocalTime(12, 30, 0, 0).withDefaultZoneId().toCalendar(),
				is(calendar));

		localDateTime = DateConvert.from(calendar).toLocalDateTime();
		assertThat(DateConvert.from(localDate).withLocalTime(12, 30, 0, 0).withDefaultZoneId().toCalendar(),
				is(calendar));

		zonedDateTime = DateConvert.from(calendar).toZonedDateTimeWithDefaultZone();
		assertThat(DateConvert.from(zonedDateTime).toCalendar(), is(calendar));

		millis = DateConvert.from(calendar).toMillis();
		assertThat(DateConvert.from(millis).toCalendar(), is(calendar));

		timestamp = DateConvert.from(calendar).toTimestamp();
		assertThat(DateConvert.from(timestamp).toCalendar(), is(calendar));
	}

	@Test
	public void converting_from_to_instant() {
		calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(2018, 1, 1, 10, 15);
		instant = calendar.getTime().toInstant();

		date = DateConvert.from(instant).toDate();
		assertThat(DateConvert.from(date).toInstant(), is(instant));

		calendar = DateConvert.from(instant).toCalendar();
		assertThat(DateConvert.from(calendar).toInstant(), is(instant));

		localDate = DateConvert.from(instant).toLocalDate();
		assertThat(DateConvert.from(localDate).withLocalTime(10, 15, 0, 0).withDefaultZoneId().toInstant(),
				is(instant));

		localDateTime = DateConvert.from(instant).toLocalDateTime();
		assertThat(DateConvert.from(localDate).withLocalTime(10, 15, 0, 0).withDefaultZoneId().toInstant(),
				is(instant));

		zonedDateTime = DateConvert.from(instant).toZonedDateTimeWithDefaultZone();
		assertThat(DateConvert.from(zonedDateTime).toInstant(), is(instant));

		millis = DateConvert.from(instant).toMillis();
		assertThat(DateConvert.from(millis).toInstant(), is(instant));

		timestamp = DateConvert.from(instant).toTimestamp();
		assertThat(DateConvert.from(timestamp).toInstant(), is(instant));
	}

}
