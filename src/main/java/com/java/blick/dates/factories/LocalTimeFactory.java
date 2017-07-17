package com.java.blick.dates.factories;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;

public class LocalTimeFactory {

	private long millis;

	public LocalTimeFactory(long millis) {
		this.millis = millis;
	}

	public LocalTime withZone(ZoneId zone) {
		return Instant.ofEpochMilli(millis).atZone(zone).toLocalTime();
	}

	public LocalTime withDefaultZone() {
		return withZone(ZoneId.systemDefault());
	}
}
