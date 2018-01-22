package com.java.blick.dates.converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Objects;

public final class LocalDateTimes {

	private LocalDateTime localDateTime;

	public LocalDateTimes(LocalDateTime localDateTime) {
		Objects.requireNonNull(localDateTime);
		this.localDateTime = localDateTime;
	}

	public LocalDateTime get() {
		return localDateTime;
	}

	public LocalDateTime toLocalDateTime() {
		return get();
	}

	public ZonedDateTimes toZonedDateTimes(ZoneId zone) {
		return new ZonedDateTimes(localDateTime.atZone(zone));
	}

	public ZonedDateTimes toZonedDateTimes() {
		return toZonedDateTimes(ZoneId.systemDefault());
	}

	public LocalDate toLocalDate() {
		return localDateTime.toLocalDate();
	}

	public LocalTime toLocalTime() {
		return localDateTime.toLocalTime();
	}
}
