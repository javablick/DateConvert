package com.java.blick.dates.factories;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class LocalDateFactory {

	private long millis;

	public LocalDateFactory(long millis) {
		this.millis = millis;
	}

	public LocalDate withZone(ZoneId zone) {
		return Instant.ofEpochMilli(millis).atZone(zone).toLocalDate();
	}

	public LocalDate withDefaultZone() {
		return withZone(ZoneId.systemDefault());
	}

}
