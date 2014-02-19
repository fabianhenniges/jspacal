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

    public Double topocentricZenithAngle(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getTopocentricZenithAngle();
	}

	return null;
    }

    public Double topocentricElevationAngle(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getTopocentricElevationAngleCorrected();
	}

	return null;
    }

    public Double topocentricAzimuthAngle(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getTopocentricAzimuthAngleEastwardFromNorth();
	}

	return null;
    }

    public Double topocentricAzmiuthAngleWestFromSouth(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getTopocentricAzimuthAngleWestwardFromSouth();
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

    public Double localSunriseTime(LocalDate localDate) {
	DateTime datetime = localDate.toDateTime(new LocalTime(12, 0, 0, 0));
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getLocalSunriseTime();
	}

	return null;
    }

    public Double localSunsetTime(LocalDate localDate) {
	DateTime datetime = localDate.toDateTime(new LocalTime(12, 0, 0, 0));
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getLocalSunsetTime();
	}

	return null;
    }

    public Double localSuntransitTime(LocalDate localDate) {
	DateTime datetime = localDate.toDateTime(new LocalTime(12, 0, 0, 0));
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getLocalSunTransitTime();
	}

	return null;
    }

    public Double julianDay(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getJulianDay();
	}

	return null;
    }

    public Double julianCentury(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getJulianCentury();
	}

	return null;
    }

    public Double julianEphemerisDay(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getJulianEphemerisDay();
	}

	return null;
    }

    public Double julianEphemerisCentury(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getJulianEphemerisCentury();
	}

	return null;
    }

    public Double julianEphemerisMillenium(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getJulianEphemerisMillenium();
	}

	return null;
    }

    public Double earthHeliocentricLongitude(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getEarthHeliocentricLongitude();
	}

	return null;
    }

    public Double earthHeliocentricLatitude(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getEarthHeliocentricLatitude();
	}

	return null;
    }

    public Double earthRadiusVector(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getEarthRadiusVector();
	}

	return null;
    }

    public Double geocentricLongitude(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getGeocentricLongitude();
	}

	return null;
    }

    public Double geocentricLatitude(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getGeocentricLatitude();
	}

	return null;
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

    public Double topocentricSunDeclination(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getTopocentricSunDeclination();
	}

	return null;
    }

    public Double topocentricSunRightAscension(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getTopocentricSunRightAscension();
	}

	return null;
    }

    public Double topocentricLocalHourAngle(DateTime datetime) {
	SolarPositionAlgorithmParameters parameters = new SolarPositionAlgorithmParameters(datetime, longitude,
		latitude, altitude);

	if (parameters.areValid()) {
	    SolarPositionAlgorithmSolver solver = new SolarPositionAlgorithmSolver(parameters);
	    return solver.solve().getTopocentricLocalHourAngle();
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

}
