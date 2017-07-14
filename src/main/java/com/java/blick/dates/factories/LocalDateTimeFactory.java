package com.java.blick.dates.factories;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class LocalDateTimeFactory {

	private Date date;

	public LocalDateTimeFactory(Date date) {
		this.date = date;
	}

	public LocalDateTime withZone(ZoneId zone) {
		return LocalDateTime.ofInstant(date.toInstant(), zone);
	}

	public LocalDateTime withDefaultZone() {
		return withZone(ZoneId.systemDefault());
	}

}
