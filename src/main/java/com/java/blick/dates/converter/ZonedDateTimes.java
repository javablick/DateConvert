package com.java.blick.dates.converter;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

import com.java.blick.dates.converter.abstracts.DatesWithZone;

public class ZonedDateTimes extends DatesWithZone {

	private ZonedDateTime zonedDateTime;

	public ZonedDateTimes(ZonedDateTime zonedDateTime) {
		Objects.requireNonNull(zonedDateTime);
		this.zonedDateTime = zonedDateTime;
	}

	@Override
	protected ZonedDateTime toZonedDateTime() {
		return zonedDateTime;
	}

	public Date toDate() {
		return new Date(toMillis());
	}

	public Timestamp toTimestamp() {
		return new Timestamp(toMillis());
	}

	@Override
	public Calendar toCalendar() {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setTimeZone(TimeZone.getTimeZone(zonedDateTime.getZone()));
		calendar.setTimeInMillis(toMillis());
		return calendar;
	}

	public Instant toInstant() {
		return zonedDateTime.toInstant();
	}

	public long toMillis() {
		return toInstant().toEpochMilli();
	}

}
