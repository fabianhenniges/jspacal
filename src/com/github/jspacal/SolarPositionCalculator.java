/**
 @COPYRIGHT@
 */
package com.github.jspacal;

import org.joda.time.DateTime;

public class SolarPositionCalculator {

    private double longitude;
    private double latitude;
    private double altitude;

    public SolarPositionCalculator(double longitude, double latitude, double altitude) {
	this.longitude = longitude;
	this.latitude = latitude;
	this.altitude = altitude;
    }

    public double calculateSunTopocentricZenithAngle(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters();
	parameters.setYear(datetime.getYear());
	parameters.setMonthOfYear(datetime.getMonthOfYear());
	parameters.setDayOfMonth(datetime.getDayOfMonth());
	parameters.setHourOfDay(datetime.getHourOfDay());
	parameters.setMinuteOfHour(datetime.getMinuteOfHour());
	parameters.setSecondOfMinute(datetime.getSecondOfMinute());
	parameters.setTimezone(datetime.getZone().getOffset(null) / 3600000.0);
	parameters.setLongitude(longitude);
	parameters.setLatitude(latitude);
	parameters.setAltitude(altitude);

	SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	return solver.solve().getTopocentricZenithAngle();
    }

}
