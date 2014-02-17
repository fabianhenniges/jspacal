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

    public double calculateSunElevation(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters();
	parameters.setYear(datetime.getYear());
	parameters.setMonthOfYear(datetime.getMonthOfYear());
	parameters.setDayOfMonth(datetime.getDayOfMonth());
	parameters.setHourOfDay(datetime.getHourOfDay());
	parameters.setMinuteOfHour(datetime.getMinuteOfHour());
	parameters.setSecondOfMinute(datetime.getSecondOfMinute());
	parameters.setTimezone(0.0);

	SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	return solver.solve().getTopocentricZenithAngle();
    }

}
