package com.java.blick.dates;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
		assertThat(DateConvert.from(timestamp), is(date));
	}

	@Test
	public void converting_from_to_calendar() {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(2018, 1, 1, 12, 30);

		date = DateConvert.from(cal).toDate();
		assertThat(DateConvert.from(date).toCalendar(), is(cal));

		instant = DateConvert.from(cal).toInstant();
		assertThat(DateConvert.from(instant).toCalendar(), is(cal));

		localDate = DateConvert.from(cal).toLocalDate();
		assertThat(DateConvert.from(localDate).withLocalTime(12, 30, 0, 0).withDefaultZoneId().toCalendar(), is(cal));

		localDateTime = DateConvert.from(cal).toLocalDateTime();
		assertThat(DateConvert.from(localDate).withLocalTime(12, 30, 0, 0).withDefaultZoneId().toCalendar(), is(cal));

		zonedDateTime = DateConvert.from(cal).toZonedDateTimeWithDefaultZone();
		assertThat(DateConvert.from(zonedDateTime).toCalendar(), is(cal));

		millis = DateConvert.from(cal).toMillis();
		assertThat(DateConvert.from(millis).toCalendar(), is(cal));

		timestamp = DateConvert.from(cal).toTimestamp();
		assertThat(DateConvert.from(timestamp).toCalendar(), is(cal));
	}

}
