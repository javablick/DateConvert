package com.java.blick.dates.converter;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

import com.java.blick.dates.converter.abstracts.DateWithoutZone;

public final class Dates extends DateWithoutZone {

	private Date date;

	public Dates(Date date) {
		Objects.requireNonNull(date);
		this.date = date;
	}

	public Timestamp toTimestamp() {
		return new Timestamp(date.getTime());
	}

	public Instant toInstant() {
		return date.toInstant();
	}

	public long toMillis() {
		return date.getTime();
	}
}
