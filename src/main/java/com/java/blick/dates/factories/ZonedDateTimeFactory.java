package com.java.blick.dates.factories;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeFactory {

	private long millis;

	public ZonedDateTimeFactory(long millis) {
		this.millis = millis;
	}

	public ZonedDateTime withZone(ZoneId zone) {
		return ZonedDateTime.ofInstant(Instant.ofEpochMilli(millis), zone);
	}

	public ZonedDateTime withDefaultZone() {
		return withZone(ZoneId.systemDefault());
	}
}
