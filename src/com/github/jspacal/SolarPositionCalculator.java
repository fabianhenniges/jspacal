/**
 @COPYRIGHT@
 */
package com.github.jspacal;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class SolarPositionCalculator {

    private double longitude;
    private double latitude;
    private double altitude;

    public SolarPositionCalculator(double longitude, double latitude, double altitude) {
	this.longitude = longitude;
	this.latitude = latitude;
	this.altitude = altitude;
    }

    public Double calculateTopocentricZenithAngle(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getTopocentricZenithAngle();
	}

	return null;
    }

    public Double calculateTopocentricElevationAngle(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getTopocentricElevationAngleCorrected();
	}

	return null;
    }

    public Double calculateTopocentricAzimuthAngle(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getTopocentricAzimuthAngleEastwardFromNorth();
	}

	return null;
    }

    public Double calculateTopocentricAzmiuthAngleWestFromSouth(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getTopocentricAzimuthAngleWestwardFromSouth();
	}

	return null;
    }

    public Double calculateSurfaceIncidenceAngle(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getSurfaceIncidenceAngle();
	}

	return null;
    }

    public Double calculateLocalSunriseTime(LocalDate localDate) {
	DateTime datetime = localDate.toDateTime(new LocalTime(12, 0, 0, 0));
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getLocalSunriseTime();
	}

	return null;
    }

    public Double calculateLocalSunsetTime(LocalDate localDate) {
	DateTime datetime = localDate.toDateTime(new LocalTime(12, 0, 0, 0));
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getLocalSunsetTime();
	}

	return null;
    }

    public Double calculateLocalSuntransitTime(LocalDate localDate) {
	DateTime datetime = localDate.toDateTime(new LocalTime(12, 0, 0, 0));
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getLocalSunTransitTime();
	}

	return null;
    }

}
