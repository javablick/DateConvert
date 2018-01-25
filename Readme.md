# DateConvert

Java library to convert common Date/Time classes

## Usage

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

## Quickstart

1. Add JitPack repository to your build file, see [here](https://jitpack.io/)
2. Add the DateConvert dependency

For maven the pom.xml looks like
```xml
...
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
...
<dependencies>
	<dependency>
		<groupId>com.github.javablick</groupId>
		<artifactId>dateconvert</artifactId>
		<version>1.0.0</version>
	</dependency>
</dependencies>

```
3. Use the DateConvert class, e.g. DateConvert.from(date).toCalendar(); 

## Questions? Need help?
Write me an [email](mailto:michael.kosin@java-blick.com?Subject=DateConvert).

See also my [homepage](https://www.java-blick.com).


