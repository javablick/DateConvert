package com.java.blick.dates.factories;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class LocalDateTimeFactory {

	private Date date;

	public LocalDateTimeFactory(Date date) {
		this.date = date;
	}

	public LocalDateTime withDefaultZone() {
		return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
	}

	public LocalDateTime withZone(ZoneId zone) {
		return LocalDateTime.ofInstant(date.toInstant(), zone);
	}

}
