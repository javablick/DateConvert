package com.java.blick.dates;

import java.sql.Timestamp;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;

import com.java.blick.dates.factories.LocalDateFactory;
import com.java.blick.dates.factories.LocalDateTimeFactory;
import com.java.blick.dates.factories.LocalTimeFactory;

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

	public static LocalTimeFactory toLocalTime(Date date) {
		if (date == null)
			return null;
		return new LocalTimeFactory(date);
	}

	public static Month toMonth(Date date) {
		if (date == null)
			return null;
		Calendar calendar = toCalendar(date);
		return Month.of(calendar.get(Calendar.MONTH) + 1);
	}

	public static Year toYear(Date date) {
		if (date == null)
			return null;
		Calendar calendar = toCalendar(date);
		return Year.of(calendar.get(Calendar.YEAR));
	}

	public static YearMonth toYearMonth(Date date) {
		if (date == null)
			return null;
		Calendar calendar = toCalendar(date);
		return YearMonth.of(calendar.get(Calendar.YEAR), toMonth(date));
	}

	public static Calendar toCalendar(Date date) {
		if (date == null)
			return null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}


}
