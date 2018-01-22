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
		
		localDate = DateConvert.from(date).toLocalDate();
		assertThat(DateConvert.from(localDate).toLocalDateTimes(12, 30, 0).toZonedDateTimes().toDate(), is(date));

		localDateTime = DateConvert.from(date).toLocalDateTime();
		assertThat(DateConvert.from(localDateTime).toZonedDateTimes().toDate(), is(date));

		zonedDateTime = DateConvert.from(date).toZonedDateTime();
		assertThat(DateConvert.from(zonedDateTime).toDate(), is(date));

		millis = DateConvert.from(date).toMillis();
		assertThat(DateConvert.from(millis).toDate(), is(date));

		timestamp = DateConvert.from(date).toTimestamp();
		assertThat(DateConvert.from(timestamp), is(date));
	}

}
