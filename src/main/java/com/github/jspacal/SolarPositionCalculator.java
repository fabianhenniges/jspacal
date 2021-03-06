/**
 @COPYRIGHT@
 */
package com.github.jspacal;

import static com.github.jspacal.algorithm.SolarPositionAlgorithmConstants.APPNAME;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jspacal.algorithm.SolarPositionAlgorithmParameters;
import com.github.jspacal.algorithm.SolarPositionAlgorithmSolver;
import com.github.jspacal.algorithm.SolarPositionAlgorithmSolverSolution;
import com.github.jspacal.position.earth.EarthPosition;
import com.github.jspacal.position.earth.EarthPositionSpecification;
import com.github.jspacal.position.solar.SolarPosition;
import com.github.jspacal.position.solar.SolarPositionSpecification;
import com.github.jspacal.solartime.SolarTime;
import com.github.jspacal.solartime.SolarTimeIndication;
import com.github.jspacal.solartime.SolarTimeSpecification;
import com.github.junits.angle.AngleUnit;
import com.github.junits.angle.AngleValue;
import com.github.junits.length.LengthValue;

public class SolarPositionCalculator {
    private static final Logger LOGGER = LoggerFactory
	    .getLogger(SolarPositionCalculator.class);

    private AngleValue longitude;
    private AngleValue latitude;
    private LengthValue altitude;

    public SolarPositionCalculator(AngleValue longitude, AngleValue latitude,
	    LengthValue altitude) {
	this.longitude = longitude;
	this.latitude = latitude;
	this.altitude = altitude;
    }

    public EarthPositionSpecification getEarthPosition() {

	return new EarthPositionSpecification() {

	    @Override
	    public EarthPosition forDateTime(DateTime datetime) {
		SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(
			datetime, longitude.inDegrees(), latitude.inDegrees(),
			altitude.inMeters());
		if (!parameters.areValid()) {
		    LOGGER.error("[{}] calculation error", APPNAME);
		    return null;
		}

		return new EarthPosition(new SolarPositionAlgorithmSolver(
			parameters).solve());
	    }
	};
    }

    public SolarPositionSpecification getSolarPosition() {

	return new SolarPositionSpecification() {

	    @Override
	    public SolarPosition forDateTime(DateTime datetime) {
		SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(
			datetime, longitude.inDegrees(), latitude.inDegrees(),
			altitude.inMeters());
		if (!parameters.areValid()) {
		    LOGGER.error("[{}] calculation error", APPNAME);
		    return null;
		}

		return new SolarPosition(new SolarPositionAlgorithmSolver(
			parameters).solve());
	    }

	    @Override
	    public SolarPosition atSunset(LocalDate localdate) {
		DateTime datetime = localdate.toDateTime(new LocalTime(),
			DateTimeZone.UTC);
		SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(
			datetime, longitude.inDegrees(), latitude.inDegrees(),
			altitude.inMeters());

		if (!parameters.areValid()) {
		    LOGGER.error("[{}] calculation error", APPNAME);
		    return null;
		}

		SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(
			parameters);
		SolarPositionAlgorithmSolverSolution solution = solver.solve();
		DateTime noon = new SolarTime(localdate,
			solution.getLocalSunTransitTime()).asDateTime();
		parameters.setDateTime(noon);
		solution = solver.solve();

		while (solution.getTopocentricElevationAngleCorrected() > 0.0) {
		    DateTime currentDateTime = parameters.getDatetime()
			    .plusMinutes(1);
		    parameters.setDateTime(currentDateTime);
		    solution = solver.solve();
		}

		return new SolarPosition(solution);
	    }

	    @Override
	    public SolarPosition atSunrise(LocalDate localdate) {
		DateTime datetime = localdate.toDateTime(new LocalTime(),
			DateTimeZone.UTC);
		SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(
			datetime, longitude.inDegrees(), latitude.inDegrees(),
			altitude.inMeters());

		if (!parameters.areValid()) {
		    LOGGER.error("[{}] calculation error", APPNAME);
		    return null;
		}

		SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(
			parameters);
		SolarPositionAlgorithmSolverSolution solution = solver.solve();
		DateTime noon = new SolarTime(localdate,
			solution.getLocalSunTransitTime()).asDateTime();
		parameters.setDateTime(noon);
		solution = solver.solve();

		while (solution.getTopocentricElevationAngleCorrected() > 0.0) {
		    DateTime currentDateTime = parameters.getDatetime()
			    .minusMinutes(1);
		    parameters.setDateTime(currentDateTime);
		    solution = solver.solve();
		}

		return new SolarPosition(solution);
	    }
	};
    }

    public SolarTimeSpecification getLocalSolarTime() {

	return new SolarTimeSpecification() {

	    @Override
	    public SolarTimeIndication forLocalDate(LocalDate localdate) {
		DateTime datetime = localdate.toDateTime(new LocalTime(0, 0, 0,
			1), DateTimeZone.UTC);
		SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(
			datetime, longitude.inDegrees(), latitude.inDegrees(),
			altitude.inMeters());

		if (!parameters.areValid()) {
		    LOGGER.error("[{}] calculation error", APPNAME);
		    return null;
		}

		SolarPositionAlgorithmSolverSolution solution = new SolarPositionAlgorithmSolver(
			parameters).solve();

		return new SolarTimeIndication(localdate, solution);
	    }

	    @Override
	    public SolarTimeIndication forDateTime(DateTime datetime) {
		SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(
			datetime, longitude.inDegrees(), latitude.inDegrees(),
			altitude.inMeters());

		if (!parameters.areValid()) {
		    LOGGER.error("[{}] calculation error", APPNAME);
		    return null;
		}

		SolarPositionAlgorithmSolverSolution solution = new SolarPositionAlgorithmSolver(
			parameters).solve();

		return new SolarTimeIndication(datetime.toLocalDate(), solution);
	    }
	};

    }

    public AngleValue surfaceIncidenceAngle(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(
		datetime, longitude.inDegrees(), latitude.inDegrees(),
		altitude.inMeters());

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(
		    parameters);
	    return new AngleValue(solver.solve().getSurfaceIncidenceAngle(),
		    AngleUnit.DEGREE);
	}

	return null;
    }

}
