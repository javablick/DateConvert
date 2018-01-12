package com.java.blick.dates;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateConvertTest {

	private static final Instant INSTANT_2018 = Instant.ofEpochMilli(1514761200);

	@Test
	public void converting_reconverting_test() {
		Date date = DateConvert.from(INSTANT_2018).toDate();
		Instant instant = DateConvert.from(date).toInstant();
		assertThat(instant, is(INSTANT_2018));

		Calendar calendar = DateConvert.from(date).toCalendar();
		// date = DateConvert.from(calendar)
	}

}
