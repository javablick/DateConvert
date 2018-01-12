Java library to convert common Date/Time classes


from / to ->		Date	Timest.	Millis	Instant	LocalD.	LocalDT	LocalT	Month	MonthD	Year	YearM	ZonedDT	Cal.	DayOfWeek

Date				/		X		X		X		X		X		X		X		X		X		X		X		X		X
Timestamp			X		/		X		X		X		X		X		X		X		X		X		X		X		X
Millis				0		X		/		X		X		X		X		X		X		X		X		X		X		X
Instant				X		X		X		/		X		X		X		X		X		X		X		X		X		X
LocalDate			X		X		X		X		/		X		-		X		X		X		X		X		X		X
LocalDateTime		X		X		X		X		X		/		X		X		X		X		X		X		X		X
LocalTime			0		0		0		0		-		0		/		-		-		-		-		0		-		0
ZonedDateTime		0		0		0		0		0		0		0		0		0		0		0		/		0		0
Calendar			0		0		0		0		0		0		0		0		0		0		0		0		/		0