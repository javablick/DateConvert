package com.java.blick.dates.factories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class LocalDateToDateFactory {

	private final LocalDate localDate;

	public LocalDateToDateFactory(LocalDate localDate) {
		this.localDate = localDate;
	}

	public Date atStartOfDayWithZone(ZoneId zone) {
		return Date.from(localDate.atStartOfDay(zone).toInstant());
	}

	public Date atStartOfDayWithDefaultZone() {
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public Date withLocalTimeAndZone(LocalTime time, ZoneId zone) {
		return Date.from(localDate.atTime(time).atZone(zone).toInstant());
	}

	public Date withLocalTimeAndDefaultZone(LocalTime time) {
		return Date.from(localDate.atTime(time).atZone(ZoneId.systemDefault()).toInstant());
	}

}
