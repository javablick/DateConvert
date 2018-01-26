package com.java.blick.dates.converter;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import com.java.blick.dates.converter.abstracts.DatesWithZone;

public final class Calendars extends DatesWithZone {

	private Calendar calendar;

	public Calendars(Calendar calendar) {
		Objects.requireNonNull(calendar);
		this.calendar = calendar;
	}

	public Date toDate() {
		return calendar.getTime();
	}

	public Timestamp toTimestamp() {
		return new Timestamp(toMillis());
	}

	public Instant toInstant() {
		return toDate().toInstant();
	}

	public long toMillis() {
		return calendar.getTimeInMillis();
	}

	@Override
	protected Calendar toCalendar() {
		return calendar;
	}

	@Override
	public ZonedDateTime toZonedDateTime() {
		Calendar calendar = toCalendar();
		return Instant.ofEpochMilli(calendar.getTimeInMillis()).atZone(calendar.getTimeZone().toZoneId());
	}

}
