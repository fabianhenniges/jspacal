/**
 @COPYRIGHT@
 */
package com.github.jspacal.solartime;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class SolarTime {
    private LocalDate localdate;
    private double fractionalHourOfDay;

    public SolarTime(LocalDate localdate, double fractionalHourOfDay) {
	this.localdate = localdate;
	this.fractionalHourOfDay = fractionalHourOfDay;
    }

    public DateTime asDateTime() {
	int hourOfDay = (int) fractionalHourOfDay;
	int minuteOfHour = (int) ((fractionalHourOfDay - hourOfDay) * 60);
	int secondOfMinute = (int) (((fractionalHourOfDay - hourOfDay) * 60 - minuteOfHour) * 60);
	return localdate.toDateTime(new LocalTime(hourOfDay, minuteOfHour, secondOfMinute), DateTimeZone.UTC);
    }

    public double asFractionalHourOfDay() {
	return fractionalHourOfDay;
    }
}
