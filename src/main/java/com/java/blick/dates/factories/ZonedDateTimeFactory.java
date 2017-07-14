package com.java.blick.dates.factories;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class ZonedDateTimeFactory {

	private Date date;

	public ZonedDateTimeFactory(Date date) {
		this.date = date;
	}

	public ZonedDateTime withZone(ZoneId zone) {
		return ZonedDateTime.ofInstant(date.toInstant(), zone);
	}

	public ZonedDateTime withDefaultZone() {
		return withZone(ZoneId.systemDefault());
	}
}
