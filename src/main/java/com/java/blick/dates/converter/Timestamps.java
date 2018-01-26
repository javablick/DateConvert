package com.java.blick.dates.converter;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

import com.java.blick.dates.converter.abstracts.DateWithoutZone;

public class Timestamps extends DateWithoutZone {

	private Timestamp timestamp;

	public Timestamps(Timestamp timestamp) {
		Objects.requireNonNull(timestamp);
		this.timestamp = timestamp;
	}

	public Date toDate() {
		return new Date(timestamp.getTime());
	}

	public Instant toInstant() {
		return timestamp.toInstant();
	}

	public long toMillis() {
		return timestamp.getTime();
	}

}
