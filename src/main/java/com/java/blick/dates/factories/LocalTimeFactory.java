package com.java.blick.dates.factories;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class LocalTimeFactory {

	private Date date;

	public LocalTimeFactory(Date date) {
		this.date = date;
	}

	public LocalTime withZone(ZoneId zone) {
		return date.toInstant().atZone(zone).toLocalTime();
	}

	public LocalTime withDefaultZone() {
		return withZone(ZoneId.systemDefault());
	}
}
