package com.java.blick.dates;

import java.sql.Timestamp;
import java.util.Date;

import com.java.blick.dates.factories.LocalDateFactory;
import com.java.blick.dates.factories.LocalDateTimeFactory;

public class Dates {

	public static Timestamp toTimestamp(Date date) {
		if (date == null)
			return null;
		return new Timestamp(date.getTime());
	}

	public static LocalDateTimeFactory toLocalDateTime(Date date) {
		if (date == null)
			return null;
		return new LocalDateTimeFactory(date);
	}

	public static LocalDateFactory toLocalDate(Date date) {
		if (date == null)
			return null;
		return new LocalDateFactory(date);
	}


}
