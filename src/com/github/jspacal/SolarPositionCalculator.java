/**
 @COPYRIGHT@
 */
package com.github.jspacal;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import com.github.jlog.Logger;

import static com.github.jspacal.SolarPositionAlgorithmConstants.APPNAME;

public class SolarPositionCalculator {
    private static final Logger LOGGER = Logger.getLogger(SolarPositionCalculator.class.getName());

    private double longitude;
    private double latitude;
    private double altitude;

    public SolarPositionCalculator(double longitude, double latitude, double altitude) {
	this.longitude = longitude;
	this.latitude = latitude;
	this.altitude = altitude;
    }

    public Julian getJulian(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (!parameters.areValid()) {
	    LOGGER.severe("[{}] calculation error", APPNAME);
	    return null;
	}

	final SolarPositionAlgorithmSolverSolution solution = new SolarPositionAlgorithmSolver(parameters).solve();

	return new Julian() {

	    @Override
	    public double day() {
		return solution.getJulianDay();
	    }

	    @Override
	    public double century() {
		return solution.getJulianCentury();
	    }

	    @Override
	    public Ephemeris ephemeris() {
		return new Ephemeris() {

		    @Override
		    public double millenium() {
			return solution.getJulianEphemerisMillenium();
		    }

		    @Override
		    public double day() {
			return solution.getJulianEphemerisDay();
		    }

		    @Override
		    public double century() {
			return solution.getJulianEphemerisCentury();
		    }
		};
	    }
	};
    }

    public SphericalCoordinates getEarthHeliocentricPosition(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (!parameters.areValid()) {
	    LOGGER.severe("[{}] calculation error", APPNAME);
	    return null;
	}

	final SolarPositionAlgorithmSolverSolution solution = new SolarPositionAlgorithmSolver(parameters).solve();

	return new SphericalCoordinates() {

	    @Override
	    public Angle longitude() {
		return solution.getEarthHeliocentricLongitude();
	    }

	    @Override
	    public Angle latitude() {
		return solution.getEarthHeliocentricLatitude();
	    }

	    @Override
	    public Length radial() {
		return solution.getEarthRadiusVector();
	    }
	};
    }

    public SolarPosition getSolarPosition(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (!parameters.areValid()) {
	    LOGGER.severe("[{}] calculation error", APPNAME);
	    return null;
	}

	final SolarPositionAlgorithmSolverSolution solution = new SolarPositionAlgorithmSolver(parameters).solve();

	return new SolarPosition() {

	    @Override
	    public EclipticCoordinates inEclipticCoordinates() {
		return new EclipticCoordinates() {

		    @Override
		    public Angle longitude() {
			return solution.getEarthHeliocentricLongitude();
		    }

		    @Override
		    public Angle latitude() {
			return solution.getEarthHeliocentricLatitude();
		    }

		    @Override
		    public Length distance() {
			return solution.getEarthRadiusVector();
		    }
		};
	    }

	    @Override
	    public EquatorialCoordinates inEquatorialCoordinates() {
		return new EquatorialCoordinates() {

		    @Override
		    public Angle rightAscension() {
			return solution.getGeocentricSunRightAscension()
		    }

		    @Override
		    public Angle hourAngle() {
			//TODO - check if OK
			return solution.getObserverHourAngle();
		    }

		    @Override
		    public Angle declination() {
			return solution.getGeocentricSunDeclination();
		    }
		};
	    }

	    @Override
	    public HorizontalCoordiantes inHorizontalCoordiantes() {
		return new HorizontalCoordiantes() {

		    @Override
		    public Angle zenith() {
			// TODO Auto-generated method stub
			return null;
		    }

		    @Override
		    public Azimuth azimuth() {
			// TODO Auto-generated method stub
			return null;
		    }

		    @Override
		    public Angle altitude() {
			// TODO Auto-generated method stub
			return null;
		    }
		};
	    }

	};

    }

    public Double meanElongationMoonSun(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getMeanElongationMoonSun();
	}

	return null;
    }

    public Double meanAnomalySun(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getMeanAnomalySun();
	}

	return null;
    }

    public Double meanAnomalyMoon(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getMeanAnomalyMoon();
	}

	return null;
    }

    public Double argumentLatitudeMoon(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getArgumentLatitudeMoon();
	}

	return null;
    }

    public Double ascendingLongitudeMoon(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getAscendingLongitudeMoon();
	}

	return null;
    }

    public Double nutationLongitude(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getNutationLongitude();
	}

	return null;
    }

    public Double nutationObliquity(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getNutationObliquity();
	}

	return null;
    }

    public Double eclipticMeanObliquity(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getEclipticMeanObliquity();
	}

	return null;
    }

    public Double eclipticTrueObliquity(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getEclipticTrueObliquity();
	}

	return null;
    }

    public Double aberrationCorrection(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getAberrationCorrection();
	}

	return null;
    }

    public Double apparentSunLongitude(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getApparentSunLongitude();
	}

	return null;
    }

    public Double greenwichMeanSiderealTime(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getGreenwichMeanSiderealTime();
	}

	return null;
    }

    public Double greenwichSiderealTime(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getGreenwichSiderealTime();
	}

	return null;
    }

    public Double surfaceIncidenceAngle(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getSurfaceIncidenceAngle();
	}

	return null;
    }

    public SolarTime getLocalSolarTime(final LocalDate localDate) {
	DateTime datetime = localDate.toDateTime(new LocalTime(12, 0, 0, 0));
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (!parameters.areValid()) {
	    LOGGER.severe("[{}] calculation error", APPNAME);
	    return null;
	}

	final SolarPositionAlgorithmSolverSolution solution = new SolarPositionAlgorithmSolver(parameters).solve();

	return new SolarTime() {

	    @Override
	    public TimeSpec suntransitTime() {
		return new TimeSpec() {

		    @Override
		    public double asFractionalHourOfDay() {
			return solution.getLocalSunTransitTime();
		    }

		    @Override
		    public DateTime asDateTime() {
			int hourOfDay = (int) solution.getLocalSunTransitTime();
			int minuteOfHour = (int) (solution.getLocalSunTransitTime() - hourOfDay) * 60;
			int secondOfMinute = (int) ((solution.getLocalSunTransitTime() - hourOfDay) * 60 - minuteOfHour) * 60;
			return localDate.toDateTime(new LocalTime(hourOfDay, minuteOfHour, secondOfMinute));
		    }
		};
	    }

	    @Override
	    public TimeSpec sunsetTime() {
		return new TimeSpec() {

		    @Override
		    public double asFractionalHourOfDay() {
			return solution.getLocalSunsetTime();
		    }

		    @Override
		    public DateTime asDateTime() {
			int hourOfDay = (int) solution.getLocalSunsetTime();
			int minuteOfHour = (int) (solution.getLocalSunsetTime() - hourOfDay) * 60;
			int secondOfMinute = (int) ((solution.getLocalSunsetTime() - hourOfDay) * 60 - minuteOfHour) * 60;
			return localDate.toDateTime(new LocalTime(hourOfDay, minuteOfHour, secondOfMinute));
		    }
		};
	    }

	    @Override
	    public TimeSpec sunriseTime() {
		return new TimeSpec() {

		    @Override
		    public double asFractionalHourOfDay() {
			return solution.getLocalSunriseTime();
		    }

		    @Override
		    public DateTime asDateTime() {
			int hourOfDay = (int) solution.getLocalSunriseTime();
			int minuteOfHour = (int) (solution.getLocalSunriseTime() - hourOfDay) * 60;
			int secondOfMinute = (int) ((solution.getLocalSunriseTime() - hourOfDay) * 60 - minuteOfHour) * 60;
			return localDate.toDateTime(new LocalTime(hourOfDay, minuteOfHour, secondOfMinute));
		    }
		};
	    }
	};
    }

    public Double geocentricSunRightAscension(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getGeocentricSunRightAscension();
	}

	return null;
    }

    public Double geocentricSunDeclination(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getGeocentricSunDeclination();
	}

	return null;
    }

    public Double observerHourAngle(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getObserverHourAngle();
	}

	return null;
    }

    public Double sunEquatorialHorizontalParallax(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getSunEquatorialHorizontalParallax();
	}

	return null;
    }

    public Double sunRightAscensionParallax(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getSunRightAscensionParallax();
	}

	return null;
    }

    public Double topocentricElevationAngleUcorrected(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getTopocentricElevationAngle();
	}

	return null;
    }

    public Double atmosphericRefractionCorrection(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getAtmosphericRefractionCorrection();
	}

	return null;
    }

    public Double equationOfTime(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getEquationOfTime();
	}

	return null;
    }

    public Double sunriseHourAngle(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getSunriseHourAngle();
	}

	return null;
    }

    public Double sunsetHourAngle(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getSunsetHourAngle();
	}

	return null;
    }

    public Double sunTransitAltitude(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getSunTransitAltitude();
	}

	return null;
    }

    public Double topocentricSunriseAzimuthAngle(LocalDate localDate) {
	DateTime datetime = localDate.toDateTime(new LocalTime(12, 0, 0, 0));
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    SolarPositionAlgorithmSolverSolution solution = solver.solve();
	    while (solution.getTopocentricElevationAngleCorrected() > 0.0) {
		parameters.setDateTime(datetime.minusMinutes(1));
		solution = solver.solve();
	    }
	    return solution.getTopocentricAzimuthAngleEastwardFromNorth();
	}

	return null;
    }

    public Double topocentricSunriseAzimuthAngleWestFromSouth(LocalDate localDate) {
	DateTime datetime = localDate.toDateTime(new LocalTime(12, 0, 0, 0));
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    SolarPositionAlgorithmSolverSolution solution = solver.solve();
	    while (solution.getTopocentricElevationAngleCorrected() > 0.0) {
		parameters.setDateTime(datetime.minusMinutes(1));
		solution = solver.solve();
	    }
	    return solution.getTopocentricAzimuthAngleWestwardFromSouth();
	}

	return null;
    }

    public Double topocentricSunsetAzimuthAngle(LocalDate localDate) {

	DateTime datetime = localDate.toDateTime(new LocalTime(12, 0, 0, 0));
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    SolarPositionAlgorithmSolverSolution solution = solver.solve();
	    while (solution.getTopocentricElevationAngleCorrected() > 0.0) {
		parameters.setDateTime(datetime.plusMinutes(1));
		solution = solver.solve();
	    }
	    return solution.getTopocentricAzimuthAngleEastwardFromNorth();
	}

	return null;
    }

    public Double topocentricSunsetAzimuthAngleWestFromSouth(LocalDate localDate) {
	DateTime datetime = localDate.toDateTime(new LocalTime(12, 0, 0, 0));
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    SolarPositionAlgorithmSolverSolution solution = solver.solve();
	    while (solution.getTopocentricElevationAngleCorrected() > 0.0) {
		parameters.setDateTime(datetime.plusMinutes(1));
		solution = solver.solve();
	    }
	    return solution.getTopocentricAzimuthAngleWestwardFromSouth();
	}

	return null;
    }

}
