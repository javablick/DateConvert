package com.java.blick.dates.converter;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

import com.java.blick.dates.converter.abstracts.DatesWithoutZone;

public class Instants extends DatesWithoutZone {

	private Instant instant;

	public Instants(Instant instant) {
		Objects.requireNonNull(instant);
		this.instant = instant;
	}

	public Date toDate() {
		return Date.from(instant);
	}

	public Timestamp toTimestamp() {
		return new Timestamp(toMillis());
	}

	@Override
	public long toMillis() {
		return instant.toEpochMilli();
	}

	@Override
	protected Instant toInstant() {
		return instant;
	}
}
