# DateConvert

Java library to convert common Date/Time classes

## Quickstart

Use DateConvert to convert Calendar, Instant, ZonedDateTime and even LocalDate.

For example:
```java
// Date -> Calendar
DateConvert.from(date).toCalendar();

// Calendar to UTC ZonedDateTime
DateConvert.from(calendar).toZonedDateTime(ZoneId.of("UTC"));

// LocalDate -> Date with Time 12:30 and default ZoneId
DateConvert.from(localDate).withLocalTime(12, 30, 0, 0).withDefaultZoneId().toDate();
```

## Converts from/to
- Calendar
- Date
- Instant
- LocalDate
- LocalDateTime
- Millis
- Timestamp
- ZonedDateTime

## Questions? Need help?
Write me an [email](mailto:michael.kosin@java-blick.com?Subject=DateConvert).

See also my [homepage](https://www.java-blick.com).


