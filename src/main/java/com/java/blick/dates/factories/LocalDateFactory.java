package com.java.blick.dates.factories;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class LocalDateFactory {

	private Date date;

	public LocalDateFactory(Date date) {
		this.date = date;
	}

	public LocalDate withDefaultZone() {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public LocalDate withZone(ZoneId zone) {
		return date.toInstant().atZone(zone).toLocalDate();
	}

}
