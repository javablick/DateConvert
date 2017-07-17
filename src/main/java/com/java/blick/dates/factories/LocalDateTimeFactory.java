package com.java.blick.dates.factories;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class LocalDateTimeFactory {

	private long millis;

	public LocalDateTimeFactory(long millis) {
		this.millis = millis;
	}

	public LocalDateTime withZone(ZoneId zone) {
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), zone);
	}

	public LocalDateTime withDefaultZone() {
		return withZone(ZoneId.systemDefault());
	}

}
