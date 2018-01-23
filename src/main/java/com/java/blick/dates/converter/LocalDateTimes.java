package com.java.blick.dates.converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

public final class LocalDateTimes {

	private LocalDateTime localDateTime;

	public LocalDateTimes(LocalDateTime localDateTime) {
		Objects.requireNonNull(localDateTime);
		this.localDateTime = localDateTime;
	}

	public LocalDateTime toLocalDateTime() {
		return localDateTime;
	}

	public ZonedDateTime toZonedDateTime(ZoneId zone) {
		return withZone(zone).toZonedDateTime();
	}

	public ZonedDateTime toZonedDateTimeWithDefaultZone() {
		return withZone(ZoneId.systemDefault()).toZonedDateTime();
	}

	public ZonedDateTimes withZone(ZoneId zone) {
		return new ZonedDateTimes(localDateTime.atZone(zone));
	}

	public ZonedDateTimes withDefaultZoneId() {
		return withZone(ZoneId.systemDefault());
	}

	public LocalDate toLocalDate() {
		return localDateTime.toLocalDate();
	}

	public LocalTime toLocalTime() {
		return localDateTime.toLocalTime();
	}
}
