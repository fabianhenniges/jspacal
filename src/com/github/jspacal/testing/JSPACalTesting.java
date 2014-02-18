package com.github.jspacal.testing;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.github.jspacal.SolarPositionCalculator;

public class JSPACalTesting {

    public static void main(String[] args) {
	SolarPositionCalculator solarCalculator = new SolarPositionCalculator(-105.178, 39.743, 1829);
	DateTime datetime = new DateTime(2014, 2, 18, 10, 0, 0, 0, DateTimeZone.UTC);

	System.out.print(solarCalculator.calculateSunTopocentricZenithAngle(datetime));
    }

}
