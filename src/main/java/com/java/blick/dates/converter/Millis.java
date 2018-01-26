package com.java.blick.dates.converter;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

import com.java.blick.dates.converter.abstracts.DateWithoutZone;

public final class Millis extends DateWithoutZone {

	private long millis;

	public Millis(long millis) {
		this.millis = millis;
	}

	public Timestamp toTimestamp() {
		return new Timestamp(millis);
	}

	public Instant toInstant() {
		return Instant.ofEpochMilli(millis);
	}

	public Date toDate() {
		return new Date(millis);
	}

	@Override
	protected long toMillis() {
		return millis;
	}
}
