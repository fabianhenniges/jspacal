package com.github.jspacal.testing;

import org.joda.time.DateTime;

import com.github.jspacal.SolarPositionCalculator;

public class JSPACalTesting {

    public static void main(String[] args) {
	SolarPositionCalculator solarCalculator = new SolarPositionCalculator(-105.178, 39.743, 1829);
	DateTime datetime = new DateTime();

	System.out.print(solarCalculator.calculateSunElevation(datetime));
    }

}
