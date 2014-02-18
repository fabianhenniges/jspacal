/**
 @COPYRIGHT@
 */
package com.github.jspacal;

import static com.github.jspacal.SolarPositionAlgorithmConstants.*;

public class SolarPositionAlgorithmSolver {
    private SolarPositionAlgorithmParameters parameters;

    public SolarPositionAlgorithmSolver(SolarPositionAlgorithmParameters parameters) {
	this.parameters = parameters;
    }

    public SolarPositionAlgorithmSolverSolution solve() {
	SolarPositionAlgorithmSolverSolution solution = new SolarPositionAlgorithmSolverSolution();

	double julianDay = calculateJulianDay();
	solution.setJulianDay(julianDay);

	calculateGeocentricSunRightAscensionAndDeclination(solution);

	double observerHourAngle = calculateObserverHourAngle(solution.getGreenwichSiderealTime(),
		solution.getGeocentricSunRightAscension());
	solution.setObserverHourAngle(observerHourAngle);

	double sunEquatorialHorizontalParallax = calculateSunEquatorialHorizontalParallax(solution
		.getEarthRadiusVector());
	solution.setSunEquatorialHorizontalParallax(sunEquatorialHorizontalParallax);

	double sunRightAscensionParallax = calculateSunRightAscensionParallax(sunEquatorialHorizontalParallax,
		observerHourAngle, solution.getGeocentricSunDeclination());
	solution.setSunRightAscensionParallax(sunRightAscensionParallax);

	double topocentricSunDeclination = calculateTopocentricSunDeclination(sunEquatorialHorizontalParallax,
		observerHourAngle, solution.getGeocentricSunDeclination());
	solution.setTopocentricSunDeclination(topocentricSunDeclination);

	double topocentricSunRightAscension = calculateTopocentricSunRightAscension(
		solution.getGeocentricSunRightAscension(), sunRightAscensionParallax);
	solution.setTopocentricSunRightAscension(topocentricSunRightAscension);

	double topocentricLocalHourAngle = calculateTopocentricLocalHourAngle(observerHourAngle,
		sunRightAscensionParallax);
	solution.setTopocentricLocalHourAngle(topocentricLocalHourAngle);

	double topocentricElevationAngle = calculateTopocentricElevationAngle(topocentricSunDeclination,
		topocentricLocalHourAngle);
	solution.setTopocentricElevationAngle(topocentricElevationAngle);

	double atmosphericRefractionCorrection = calculateAtmosphericRefractionCorrection(topocentricElevationAngle);
	solution.setAtmosphericRefractionCorrection(atmosphericRefractionCorrection);

	double topocentricElevationAngleCorrected = calculateTopocentricElevationAngleCorrected(
		topocentricElevationAngle, atmosphericRefractionCorrection);
	solution.setTopocentricElevationAngleCorrected(topocentricElevationAngleCorrected);

	calculateEoTAndSTS(solution);

	double topocentricZenithAngle = calculateTopocentricZenithAngle(topocentricElevationAngleCorrected);
	solution.setTopocentricZenithAngle(topocentricZenithAngle);

	double topocentricAzimuthAngleWestwardFromSouth = calculateTopocentricAzimuthAngleNeg180Pos180(
		topocentricLocalHourAngle, topocentricSunDeclination);
	solution.setTopocentricAzimuthAngleWestwardFromSouth(topocentricAzimuthAngleWestwardFromSouth);

	double topocentricAzimuthAngleEastwardFromNorth = calculateTopocentricAzimuthAngleZero360(topocentricAzimuthAngleWestwardFromSouth);
	solution.setTopocentricAzimuthAngleEastwardFromNorth(topocentricAzimuthAngleEastwardFromNorth);

	double surfaceIncidenceAngle = calculateSurfaceIncidenceAngle(topocentricZenithAngle,
		topocentricAzimuthAngleWestwardFromSouth);
	solution.setSurfaceIncidenceAngle(surfaceIncidenceAngle);

	return solution;
    }

    private double calculateJulianDay() {
	int year = parameters.getYear();
	int monthOfYear = parameters.getMonthOfYear();
	int dayOfMonth = parameters.getDayOfMonth();
	int hourOfDay = parameters.getHourOfDay();
	int minuteOfHour = parameters.getMinuteOfHour();
	int secondOfMinute = parameters.getSecondOfMinute();
	double timezone = parameters.getTimezone();

	double dayDecimal = dayOfMonth + (hourOfDay - timezone + (minuteOfHour + secondOfMinute / 60.0) / 60.0) / 24.0;

	if (monthOfYear < 3) {
	    monthOfYear += 12;
	    year--;
	}

	double julianDay = Math.floor(365.25 * (year + 4716.0)) + Math.floor(30.6001 * (monthOfYear + 1)) + dayDecimal
		- 1524.5;

	if (julianDay > 2299160.0) {
	    double a = Math.floor(year / 100);
	    julianDay += (2 - a + Math.floor(a / 4));
	}

	return julianDay;
    }

    private void calculateGeocentricSunRightAscensionAndDeclination(SolarPositionAlgorithmSolverSolution solution) {
	double julianCentury = calculateJulianCentury(solution.getJulianDay());
	solution.setJulianCentury(julianCentury);

	double julianEphemerisDay = calculateJulianEphemerisDay(solution.getJulianDay());
	solution.setJulianEphemerisDay(julianEphemerisDay);

	double julianEphemerisCentury = calculateJulianEphemerisCentury(julianEphemerisDay);
	solution.setJulianEphemerisCentury(julianEphemerisCentury);

	double julianEphemerisMillenium = calculateJulianEphemerisMillennium(julianEphemerisCentury);
	solution.setJulianEphemerisMillenium(julianEphemerisMillenium);

	double earthHeliocentricLongitude = calculateEarthHeliocentricLongitude(julianEphemerisMillenium);
	solution.setEarthHeliocentricLongitude(earthHeliocentricLongitude);

	double earthHeliocentricLatitude = calculateEarthHeliocentricLatitude(julianEphemerisMillenium);
	solution.setEarthHeliocentricLatitude(earthHeliocentricLatitude);

	double earthRadiusVector = calculateEarthRadiusVector(julianEphemerisMillenium);
	solution.setEarthRadiusVector(earthRadiusVector);

	double geocentricLongitude = calculateGeocentricLongitude(earthHeliocentricLongitude);
	solution.setGeocentricLongitude(geocentricLongitude);

	double geocentricLatitude = calculateGeocentricLatitude(earthHeliocentricLatitude);
	solution.setGeocentricLatitude(geocentricLatitude);

	double meanElongationMoonSun = calculateMeanElongationMoonSun(julianEphemerisCentury);
	solution.setMeanElongationMoonSun(meanElongationMoonSun);

	double meanAnomalySun = calculateMeanAnomalySun(julianEphemerisCentury);
	solution.setMeanAnomalySun(meanAnomalySun);

	double meanAnomalyMoon = calculateMeanAnomalyMoon(julianEphemerisCentury);
	solution.setMeanAnomalyMoon(meanAnomalyMoon);

	double argumentLatitudeMoon = calculateArgumentLatitudeMoon(julianEphemerisCentury);
	solution.setArgumentLatitudeMoon(argumentLatitudeMoon);

	double ascendingLongitudeMoon = calculateAscendingLongitudeMoon(julianEphemerisCentury);
	solution.setAscendingLongitudeMoon(ascendingLongitudeMoon);

	double[] x = new double[TERM_X.values().length];
	x[TERM_X.TERM_X0.ordinal()] = meanElongationMoonSun;
	x[TERM_X.TERM_X1.ordinal()] = meanAnomalySun;
	x[TERM_X.TERM_X2.ordinal()] = meanAnomalyMoon;
	x[TERM_X.TERM_X3.ordinal()] = argumentLatitudeMoon;
	x[TERM_X.TERM_X4.ordinal()] = ascendingLongitudeMoon;

	double nutationLongitude = calculateNutationLongitude(julianEphemerisCentury, x);
	solution.setNutationLongitude(nutationLongitude);
	double nutationObliquity = calculateNutationOliquity(julianEphemerisCentury, x);
	solution.setNutationObliquity(nutationObliquity);

	double eclipticMeanObliquity = calculateEclipticMeanObliquity(julianEphemerisMillenium);
	solution.setEclipticMeanObliquity(eclipticMeanObliquity);
	double eclipticTrueObliquity = calculateEclipticTrueObliquity(nutationObliquity, eclipticMeanObliquity);
	solution.setEclipticTrueobliquity(eclipticTrueObliquity);

	double aberrationCorrection = calculateAberrationCorrection(earthRadiusVector);
	solution.setAberrationCorrection(aberrationCorrection);
	double apparentSunLongitude = calculateApparentSunLongitude(geocentricLongitude, nutationLongitude,
		aberrationCorrection);
	solution.setApparentSunLongitude(apparentSunLongitude);
	double greenwichMeanSiderealTime = calculateGreenwichMeanSiderealTime(solution.getJulianDay(), julianCentury);
	solution.setGreenwichMeanSiderealTime(greenwichMeanSiderealTime);
	double greenwichSiderealTime = calculateGreenwichSiderealTime(greenwichMeanSiderealTime, nutationLongitude,
		eclipticTrueObliquity);
	solution.setGreenwichSiderealTime(greenwichSiderealTime);

	double geocentricSunRightAscension = calculateGeocentricSunRightAscension(apparentSunLongitude,
		eclipticTrueObliquity, geocentricLatitude);
	solution.setGeocentricSunRightAscension(geocentricSunRightAscension);
	double geocentricSunDeclination = calculateGeocentricSunDeclination(apparentSunLongitude,
		eclipticTrueObliquity, geocentricLatitude);
	solution.setGeocentricSunDeclination(geocentricSunDeclination);
    }

    private double calculateJulianCentury(double julianDay) {
	return (julianDay - 2451545.0) / 36525.0;
    }

    private double calculateJulianEphemerisDay(double julianDay) {
	return julianDay + parameters.getDeltaT() / 86400.0;
    }

    private double calculateJulianEphemerisCentury(double julianEphemerisDay) {
	return (julianEphemerisDay - 2451545.0) / 36525.0;
    }

    private double calculateJulianEphemerisMillennium(double julianEphemerisCentury) {
	return julianEphemerisCentury / 10.0;
    }

    private double calculateEarthHeliocentricLongitude(double julianEphemerisMillenium) {
	double[] sum = new double[L_SUBCOUNT.length];
	int i;

	for (i = 0; i < L_SUBCOUNT.length; i++)
	    sum[i] = calculateEarthPeriodicTermSummation(julianEphemerisMillenium, L_TERMS[i], L_SUBCOUNT[i]);

	return limitDegrees(Math.toDegrees(earthValues(julianEphemerisMillenium, sum, L_SUBCOUNT.length)));
    }

    private double calculateEarthPeriodicTermSummation(double julianEphemerisMillenium, double[][] terms, int count) {
	int i;
	double sum = 0;

	for (i = 0; i < count; i++) {
	    sum += terms[i][TERM.TERM_A.ordinal()]
		    * Math.cos(terms[i][TERM.TERM_B.ordinal()] + terms[i][TERM.TERM_C.ordinal()]
			    * julianEphemerisMillenium);
	}

	return sum;
    }

    private double earthValues(double julianEphemerisMillenium, double[] termSum, int count) {
	int i;
	double sum = 0;

	for (i = 0; i < count; i++) {
	    sum += termSum[i] * Math.pow(julianEphemerisMillenium, i);
	}

	return sum /= 1.0e8;
    }

    private double limitDegrees(double degrees) {
	double limited;

	degrees /= 360.0;
	limited = 360.0 * (degrees - Math.floor(degrees));
	if (limited < 0)
	    limited += 360.0;

	return limited;
    }

    private double calculateEarthHeliocentricLatitude(double julianEphemerisMillenium) {
	double[] sum = new double[B_SUBCOUNT.length];
	int i;

	for (i = 0; i < B_SUBCOUNT.length; i++)
	    sum[i] = calculateEarthPeriodicTermSummation(julianEphemerisMillenium, B_TERMS[i], B_SUBCOUNT[i]);

	return Math.toDegrees(earthValues(julianEphemerisMillenium, sum, B_SUBCOUNT.length));
    }

    private double calculateEarthRadiusVector(double julianEphemerisMillenium) {
	double[] sum = new double[R_SUBCOUNT.length];
	int i;

	for (i = 0; i < R_SUBCOUNT.length; i++)
	    sum[i] = calculateEarthPeriodicTermSummation(julianEphemerisMillenium, R_TERMS[i], R_SUBCOUNT[i]);

	return earthValues(julianEphemerisMillenium, sum, R_SUBCOUNT.length);
    }

    private double calculateGeocentricLongitude(double earthHeliocentricLongitude) {
	double theta = earthHeliocentricLongitude + 180.0;

	if (theta >= 360.0)
	    theta -= 360.0;

	return theta;
    }

    private double calculateGeocentricLatitude(double earthHeliocentricLatitude) {
	return -earthHeliocentricLatitude;
    }

    private double thirdOrderPolynomial(double a, double b, double c, double d, double x) {
	return ((a * x + b) * x + c) * x + d;
    }

    private double calculateMeanElongationMoonSun(double julianEphemerisCentury) {
	return thirdOrderPolynomial(1.0 / 189474.0, -0.0019142, 445267.11148, 297.85036, julianEphemerisCentury);
    }

    private double calculateMeanAnomalySun(double julianEphemerisCentury) {
	return thirdOrderPolynomial(-1.0 / 300000.0, -0.0001603, 35999.05034, 357.52772, julianEphemerisCentury);
    }

    private double calculateMeanAnomalyMoon(double julianEphemerisCentury) {
	return thirdOrderPolynomial(1.0 / 56250.0, 0.0086972, 477198.867398, 134.96298, julianEphemerisCentury);
    }

    private double calculateArgumentLatitudeMoon(double julianEphemerisCentury) {
	return thirdOrderPolynomial(1.0 / 327270.0, -0.0036825, 483202.017538, 93.27191, julianEphemerisCentury);
    }

    private double calculateAscendingLongitudeMoon(double julianEphemerisCentury) {
	return thirdOrderPolynomial(1.0 / 450000.0, 0.0020708, -1934.136261, 125.04452, julianEphemerisCentury);
    }

    private double calculateNutationLongitude(double julianEphemerisCentury, double[] x) {
	double sumPsi = 0;

	for (int i = 0; i < Y_TERMS.length; i++) {
	    double xyTermSum = Math.toRadians(xyTermSummation(i, x));
	    sumPsi += (PE_TERMS[i][TERM_PSI.TERM_PSI_A.ordinal()] + julianEphemerisCentury
		    * PE_TERMS[i][TERM_PSI.TERM_PSI_B.ordinal()])
		    * Math.sin(xyTermSum);
	}

	return sumPsi / 36000000.0;
    }

    private double xyTermSummation(int i, double[] x) {
	double sum = 0;

	for (int j = 0; j < TERM_Y_COUNT; j++)
	    sum += x[j] * Y_TERMS[i][j];

	return sum;
    }

    private double calculateNutationOliquity(double julianEphemerisCentury, double[] x) {
	double sumEpsilon = 0;

	for (int i = 0; i < Y_TERMS.length; i++) {
	    double xyTermSum = Math.toRadians(xyTermSummation(i, x));
	    sumEpsilon += (PE_TERMS[i][TERM_PSI.TERM_EPS_C.ordinal()] + julianEphemerisCentury
		    * PE_TERMS[i][TERM_PSI.TERM_EPS_D.ordinal()])
		    * Math.cos(xyTermSum);
	}

	return sumEpsilon / 36000000.0;
    }

    private double calculateEclipticMeanObliquity(double julianEphemerisMillenium) {
	double u = julianEphemerisMillenium / 10.0;

	return 84381.448
		+ u
		* (-4680.93 + u
			* (-1.55 + u
				* (1999.25 + u
					* (-51.38 + u
						* (-249.67 + u
							* (-39.05 + u * (7.12 + u * (27.87 + u * (5.79 + u * 2.45)))))))));
    }

    private double calculateEclipticTrueObliquity(double nutationObliquity, double eclipticMeanObliquity) {
	return nutationObliquity + eclipticMeanObliquity / 3600.0;
    }

    private double calculateAberrationCorrection(double earthRadiusVector) {
	return -20.4898 / (3600.0 * earthRadiusVector);
    }

    private double calculateApparentSunLongitude(double geocentricLongitude, double nutationLongitude,
	    double aberationCorrection) {
	return geocentricLongitude + nutationLongitude + aberationCorrection;
    }

    private double calculateGreenwichMeanSiderealTime(double julianDay, double julianCentury) {
	return limitDegrees(280.46061837 + 360.98564736629 * (julianDay - 2451545.0) + julianCentury * julianCentury
		* (0.000387933 - julianCentury / 38710000.0));
    }

    private double calculateGreenwichSiderealTime(double greenwichMeanSiderealTime, double nutationLongitude,
	    double eclipticTrueObliquity) {
	return greenwichMeanSiderealTime + nutationLongitude * Math.cos(Math.toRadians(eclipticTrueObliquity));
    }

    private double calculateGeocentricSunRightAscension(double apparentSunLongitude, double eclipticTrueObliquity,
	    double geocentricLatitude) {
	double lamdaRad = Math.toRadians(apparentSunLongitude);
	double epsilonRad = Math.toRadians(eclipticTrueObliquity);

	return limitDegrees(Math.toDegrees(Math.atan2(
		Math.sin(lamdaRad) * Math.cos(epsilonRad) - Math.tan(Math.toRadians(geocentricLatitude))
			* Math.sin(epsilonRad), Math.cos(lamdaRad))));
    }

    private double calculateGeocentricSunDeclination(double apparentSunLongitude, double eclipticTrueObliquity,
	    double geocentricLatitude) {
	double betaRad = Math.toRadians(geocentricLatitude);
	double epsilonRad = Math.toRadians(eclipticTrueObliquity);

	return Math.toDegrees(Math.asin(Math.sin(betaRad) * Math.cos(epsilonRad) + Math.cos(betaRad)
		* Math.sin(epsilonRad) * Math.sin(Math.toRadians(apparentSunLongitude))));
    }

    private double calculateObserverHourAngle(double greenwichSiderealTime, double geocentricSunRightAscension) {
	return limitDegrees(greenwichSiderealTime + parameters.getLongitude() - geocentricSunRightAscension);
    }

    private double calculateSunEquatorialHorizontalParallax(double earthRadiusVector) {
	return 8.794 / (3600.0 * earthRadiusVector);
    }

    private double calculateSunRightAscensionParallax(double sunEquatorialHorizontalParallax, double observerHourAngle,
	    double geocentricSunDeclination) {
	double deltaAlphaRad;
	double latitudeRad = Math.toRadians(parameters.getLatitude());
	double xiRad = Math.toRadians(sunEquatorialHorizontalParallax);
	double hRad = Math.toRadians(observerHourAngle);
	double deltaRad = Math.toRadians(geocentricSunDeclination);
	double u = Math.atan(0.99664719 * Math.tan(latitudeRad));
	double x = Math.cos(u) + parameters.getAltitude() * Math.cos(latitudeRad) / 6378140.0;

	deltaAlphaRad = Math.atan2(-x * Math.sin(xiRad) * Math.sin(hRad), Math.cos(deltaRad) - x * Math.sin(xiRad)
		* Math.cos(hRad));

	return Math.toDegrees(deltaAlphaRad);
    }

    private double calculateTopocentricSunDeclination(double sunEquatorialHorizontalParallax, double observerHourAngle,
	    double geocentricSunDeclination) {
	double deltaAlphaRad;
	double latitudeRad = Math.toRadians(parameters.getLatitude());
	double xiRad = Math.toRadians(sunEquatorialHorizontalParallax);
	double hRad = Math.toRadians(observerHourAngle);
	double deltaRad = Math.toRadians(geocentricSunDeclination);
	double u = Math.atan(0.99664719 * Math.tan(latitudeRad));
	double y = 0.99664719 * Math.sin(u) + parameters.getAltitude() * Math.sin(latitudeRad) / 6378140.0;
	double x = Math.cos(u) + parameters.getAltitude() * Math.cos(latitudeRad) / 6378140.0;

	deltaAlphaRad = Math.atan2(-x * Math.sin(xiRad) * Math.sin(hRad), Math.cos(deltaRad) - x * Math.sin(xiRad)
		* Math.cos(hRad));

	return Math.toDegrees(Math.atan2((Math.sin(deltaRad) - y * Math.sin(xiRad)) * Math.cos(deltaAlphaRad),
		Math.cos(deltaRad) - x * Math.sin(xiRad) * Math.cos(hRad)));
    }

    private double calculateTopocentricSunRightAscension(double geocentricSunRightAscension,
	    double sunRightAscensionParallax) {
	return geocentricSunRightAscension + sunRightAscensionParallax;
    }

    private double calculateTopocentricLocalHourAngle(double observerHourAngle, double sunRightAscensionParallax) {
	return observerHourAngle - sunRightAscensionParallax;
    }

    private double calculateTopocentricElevationAngle(double topocentricSunDeclination, double topocentricLocalHourAngle) {
	double latitudeRad = Math.toRadians(parameters.getLatitude());
	double deltaPrimeRad = Math.toRadians(topocentricSunDeclination);

	return Math.toDegrees(Math.asin(Math.sin(latitudeRad) * Math.sin(deltaPrimeRad) + Math.cos(latitudeRad)
		* Math.cos(deltaPrimeRad) * Math.cos(Math.toRadians(topocentricLocalHourAngle))));
    }

    private double calculateAtmosphericRefractionCorrection(double topocentricElevationAngle) {
	if (topocentricElevationAngle >= -1 * (SUN_RADIUS + parameters.getAtmosphericRefraction())) {
	    return (parameters.getPressure() / 1010.0)
		    * (283.0 / (273.0 + parameters.getTemperature()))
		    * 1.02
		    / (60.0 * Math.tan(Math.toRadians(topocentricElevationAngle + 10.3
			    / (topocentricElevationAngle + 5.11))));
	} else {
	    return 0.0;
	}
    }

    private double calculateTopocentricElevationAngleCorrected(double topocentricElevationAngle,
	    double atmosphericRefractionCorrection) {
	return topocentricElevationAngle + atmosphericRefractionCorrection;
    }

    private double calculateTopocentricZenithAngle(double topocentricElevationAngleCorrected) {
	return 90.0 - topocentricElevationAngleCorrected;
    }

    private double calculateTopocentricAzimuthAngleNeg180Pos180(double topocentricLocalHourAngle,
	    double topocentricSunDeclination) {
	double hPrimeRad = Math.toRadians(topocentricLocalHourAngle);
	double latitudeRad = Math.toRadians(parameters.getLatitude());

	return Math.toDegrees(Math.atan2(Math.sin(hPrimeRad),
		Math.cos(hPrimeRad) * Math.sin(latitudeRad) - Math.tan(Math.toRadians(topocentricSunDeclination))
			* Math.cos(latitudeRad)));
    }

    private double calculateTopocentricAzimuthAngleZero360(double topocentricAzimuthAngleNeg180Pos180) {
	return topocentricAzimuthAngleNeg180Pos180 + 180.0;
    }

    private double calculateSurfaceIncidenceAngle(double topocentricZenithAngle,
	    double topocentricAzimuthAngleWestwardFromSouth) {
	double zenithRad = Math.toRadians(topocentricZenithAngle);
	double slopeRad = Math.toRadians(parameters.getSlope());

	return Math
		.toDegrees(Math.acos(Math.cos(zenithRad)
			* Math.cos(slopeRad)
			+ Math.sin(slopeRad)
			* Math.sin(zenithRad)
			* Math.cos(Math.toRadians(topocentricAzimuthAngleWestwardFromSouth
				- parameters.getAzimuthRotation()))));
    }

    private void calculateEoTAndSTS(SolarPositionAlgorithmSolverSolution solution) {
	// double nu, h0, h0dfrac, n;

	double[] a = new double[JD.values().length]; // alpha
	double[] d = new double[JD.values().length]; // delta

	double[] mRts = new double[SUN.values().length];
	double[] nuRts = new double[SUN.values().length];
	double[] hRts = new double[SUN.values().length];

	double[] aPrime = new double[SUN.values().length];
	double[] dPrime = new double[SUN.values().length];
	double[] hPrime = new double[SUN.values().length];

	double h0prime = -1 * (SUN_RADIUS + parameters.getAtmosphericRefraction());

	double sunMeanLongitude = calculateSunMeanLongitude(solution.getJulianEphemerisMillenium());
	double equationOfTime = calculateEquationOfTime(sunMeanLongitude, solution.getGeocentricSunRightAscension(),
		solution.getNutationLongitude(), solution.getEclipticTrueObliquity());
	solution.setEquationOfTime(equationOfTime);

	SolarPositionAlgorithmSolver sunRtsSolver = new SolarPositionAlgorithmSolver(parameters);
	SolarPositionAlgorithmSolverSolution sunRtsSolverSolution = new SolarPositionAlgorithmSolverSolution(solution);

	sunRtsSolver.parameters.setHourOfDay(0);
	sunRtsSolver.parameters.setMinuteOfHour(0);
	sunRtsSolver.parameters.setSecondOfMinute(0);
	sunRtsSolver.parameters.setTimezone(0.0);

	double julianDay = sunRtsSolver.calculateJulianDay();
	sunRtsSolverSolution.setJulianDay(julianDay);
	sunRtsSolver.calculateGeocentricSunRightAscensionAndDeclination(sunRtsSolverSolution);

	sunRtsSolver.parameters.setDeltaT(0);
	sunRtsSolverSolution.setJulianDay(solution.getJulianDay() - 1);

	for (int i = 0; i < JD.values().length; i++) {
	    sunRtsSolver.calculateGeocentricSunRightAscensionAndDeclination(sunRtsSolverSolution);
	    a[i] = sunRtsSolverSolution.getGeocentricSunRightAscension();
	    d[i] = sunRtsSolverSolution.getGeocentricSunDeclination();

	    sunRtsSolverSolution.setJulianDay(sunRtsSolverSolution.getJulianDay() + 1);
	}

	mRts[SUN.SUN_TRANSIT.ordinal()] = calculateApproximateSunTransitTime(a[JD.JD_ZERO.ordinal()],
		sunRtsSolverSolution.getGreenwichSiderealTime());
	double h0 = calculateSunHourAngleAtRiseSet(d[JD.JD_ZERO.ordinal()], h0prime);

	double h0dfrac;
	if (h0 >= 0) {
	    h0dfrac = h0 / 360.0; // approx_sun_rise_and_set(m_rts, h0);

	    mRts[SUN.SUN_RISE.ordinal()] = limitZero2one(mRts[SUN.SUN_TRANSIT.ordinal()] - h0dfrac);
	    mRts[SUN.SUN_SET.ordinal()] = limitZero2one(mRts[SUN.SUN_TRANSIT.ordinal()] + h0dfrac);
	    mRts[SUN.SUN_TRANSIT.ordinal()] = limitZero2one(mRts[SUN.SUN_TRANSIT.ordinal()]);

	    double n;
	    for (int i = 0; i < SUN.values().length; i++) {

		nuRts[i] = sunRtsSolverSolution.getGreenwichSiderealTime() + 360.985647 * mRts[i];

		n = mRts[i] + parameters.getDeltaT() / 86400.0;
		aPrime[i] = calculateRtsAlphaDeltaPrime(a, n);
		dPrime[i] = calculateRtsAlphaDeltaPrime(d, n);

		hPrime[i] = limitDegrees180pm(nuRts[i] + parameters.getLongitude() - aPrime[i]);

		hRts[i] = calculateRtsSunAltitude(dPrime[i], hPrime[i]);
	    }

	    solution.setSunriseHourAngle(hPrime[SUN.SUN_RISE.ordinal()]);
	    solution.setSunsetHourAngle(hPrime[SUN.SUN_SET.ordinal()]);
	    solution.setSunTransitAltitude(hRts[SUN.SUN_TRANSIT.ordinal()]);
	    solution.setLocalSunTransitTime(dayFractionToLocalHour(mRts[SUN.SUN_TRANSIT.ordinal()]
		    - hPrime[SUN.SUN_TRANSIT.ordinal()] / 360.0));
	    solution.setLocalSunriseTime(dayFractionToLocalHour(calculateSunRiseAndSet(mRts, hRts, dPrime, hPrime,
		    h0prime, SUN.SUN_RISE.ordinal())));
	    solution.setLocalSunsetTime(dayFractionToLocalHour(calculateSunRiseAndSet(mRts, hRts, dPrime, hPrime,
		    h0prime, SUN.SUN_SET.ordinal())));
	} else {
	    solution.setSunriseHourAngle(null);
	    solution.setSunsetHourAngle(null);
	    solution.setSunTransitAltitude(null);
	    solution.setLocalSunTransitTime(null);
	    solution.setLocalSunriseTime(null);
	    solution.setLocalSunsetTime(null);
	}
    }

    private double calculateSunMeanLongitude(double julianEphemerisMillenium) {
	return limitDegrees(280.4664567
		+ julianEphemerisMillenium
		* (360007.6982779 + julianEphemerisMillenium
			* (0.03032028 + julianEphemerisMillenium
				* (1 / 49931.0 + julianEphemerisMillenium
					* (-1 / 15300.0 + julianEphemerisMillenium * (-1 / 2000000.0))))));
    }

    private double calculateEquationOfTime(double sunMeanLongitude, double geocentricSunRightAscension,
	    double nutationLongitude, double eclipticTrueObliquity) {
	return limitMinutes(4.0 * (sunMeanLongitude - 0.0057183 - geocentricSunRightAscension + nutationLongitude
		* Math.cos(Math.toRadians(eclipticTrueObliquity))));
    }

    private double limitMinutes(double minutes) {
	double limited = minutes;

	if (limited < -20.0)
	    limited += 1440.0;
	else if (limited > 20.0)
	    limited -= 1440.0;

	return limited;
    }

    private double calculateApproximateSunTransitTime(double alphaZero, double greenwichSiderealTime) {
	return (alphaZero - parameters.getLongitude() - greenwichSiderealTime) / 360.0;
    }

    private double calculateSunHourAngleAtRiseSet(double deltaZero, double h0prime) {
	double h0 = -99999;
	double latitudeRad = Math.toRadians(parameters.getLatitude());
	double deltaZeroRad = Math.toRadians(deltaZero);
	double argument = (Math.sin(Math.toRadians(h0prime)) - Math.sin(latitudeRad) * Math.sin(deltaZeroRad))
		/ (Math.cos(latitudeRad) * Math.cos(deltaZeroRad));

	if (Math.abs(argument) <= 1)
	    h0 = limitDegrees180(Math.toDegrees(Math.acos(argument)));

	return h0;
    }

    private double limitDegrees180(double degrees) {
	double limited;

	degrees /= 180.0;
	limited = 180.0 * (degrees - Math.floor(degrees));
	if (limited < 0)
	    limited += 180.0;

	return limited;
    }

    private double limitZero2one(double value) {
	double limited;

	limited = value - Math.floor(value);
	if (limited < 0)
	    limited += 1.0;

	return limited;
    }

    private double calculateRtsAlphaDeltaPrime(double[] ad, double n) {
	double a = ad[JD.JD_ZERO.ordinal()] - ad[JD.JD_MINUS.ordinal()];
	double b = ad[JD.JD_PLUS.ordinal()] - ad[JD.JD_ZERO.ordinal()];

	if (Math.abs(a) >= 2.0)
	    a = limitZero2one(a);
	if (Math.abs(b) >= 2.0)
	    b = limitZero2one(b);

	return ad[JD.JD_ZERO.ordinal()] + n * (a + b + (b - a) * n) / 2.0;
    }

    private double limitDegrees180pm(double degrees) {
	double limited;

	degrees /= 360.0;
	limited = 360.0 * (degrees - Math.floor(degrees));
	if (limited < -180.0)
	    limited += 360.0;
	else if (limited > 180.0)
	    limited -= 360.0;

	return limited;
    }

    private double calculateRtsSunAltitude(double deltaPrime, double hPrime) {
	double latitudeRad = Math.toRadians(parameters.getLatitude());
	double deltaPrimeRad = Math.toRadians(deltaPrime);

	return Math.toDegrees(Math.asin(Math.sin(latitudeRad) * Math.sin(deltaPrimeRad) + Math.cos(latitudeRad)
		* Math.cos(deltaPrimeRad) * Math.cos(Math.toRadians(hPrime))));
    }

    private double dayFractionToLocalHour(double dayfrac) {
	return 24.0 * limitZero2one(dayfrac + parameters.getTimezone() / 24.0);
    }

    private double calculateSunRiseAndSet(double[] mRts, double[] hRts, double[] dPrime, double[] hPrime,
	    double h0prime, int sun) {
	return mRts[sun]
		+ (hRts[sun] - h0prime)
		/ (360.0 * Math.cos(Math.toRadians(dPrime[sun])) * Math.cos(Math.toRadians(parameters.getLatitude())) * Math
			.sin(Math.toRadians(hPrime[sun])));
    }
}
