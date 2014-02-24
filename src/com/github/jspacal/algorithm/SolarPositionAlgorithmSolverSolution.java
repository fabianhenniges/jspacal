/**
 @COPYRIGHT@
 */
package com.github.jspacal.algorithm;

public class SolarPositionAlgorithmSolverSolution {
    /*
     * Julian day
     */
    private double julianDay;

    /*
     * Julian Century
     */
    private double julianCentury;

    /*
     * Julian ephemeris day
     */
    private double julianEphemerisDay;

    /*
     * Julian ephemeris century
     */
    private double julianEphemerisCentury;

    /*
     * Julian ephemeris millennium
     */
    private double julianEphemerisMillenium;

    /*
     * earth heliocentric longitude [degrees]
     */
    private double earthHeliocentricLongitude;

    /*
     * earth heliocentric latitude [degrees]
     */
    private double earthHeliocentricLatitude;

    /*
     * earth radius vector [Astronomical Units, AU]
     */
    private double earthRadiusVector;

    /*
     * geocentric longitude [degrees]
     */
    private double geocentricLongitude;

    /*
     * geocentric latitude [degrees]
     */
    private double geocentricLatitude;

    /*
     * mean elongation (moon-sun) [degrees]
     */
    private double meanElongationMoonSun;

    /*
     * mean sun anomaly [degrees]
     */
    private double meanAnomalySun;

    /*
     * mean anomaly (moon) [degrees]
     */
    private double meanAnomalyMoon;

    /*
     * argument latitude (moon) [degrees]
     */
    private double argumentLatitudeMoon;

    /*
     * ascending longitude (moon) [degrees]
     */
    private double ascendingLongitudeMoon;

    /*
     * nutation longitude [degrees]
     */
    private double nutationLongitude;

    /*
     * nutation obliquity [degrees]
     */
    private double nutationObliquity;

    /*
     * ecliptic mean obliquity [arc seconds]
     */
    private double eclipticMeanObliquity;

    /*
     * ecliptic true obliquity [degrees]
     */
    private double eclipticTrueObliquity;

    /*
     * aberration correction [degrees]
     */
    private double aberrationCorrection;

    /*
     * apparent sun longitude [degrees]
     */
    private double apparentSunLongitude;

    /*
     * Greenwich mean sidereal time [degrees]
     */
    private double greenwichMeanSiderealTime;

    /*
     * Greenwich sidereal time [degrees]
     */
    private double greenwichSiderealTime;

    /*
     * geocentric sun right ascension [degrees]
     */
    private double geocentricSunRightAscension;

    /*
     * geocentric sun declination [degrees]
     */
    private double geocentricSunDeclination;

    /*
     * observer hour angle [degrees]
     */
    private double observerHourAngle;

    /*
     * sun equatorial horizontal parallax [degrees]
     */
    private double sunEquatorialHorizontalParallax;

    /*
     * sun right ascension parallax [degrees]
     */
    private double sunRightAscensionParallax;

    /*
     * topocentric sun declination [degrees]
     */
    private double topocentricSunDeclination;

    /*
     * topocentric sun right ascension [degrees]
     */
    private double topocentricSunRightAscension;

    /*
     * topocentric local hour angle [degrees]
     */
    private double topocentricLocalHourAngle;

    /*
     * topocentric elevation angle (uncorrected) [degrees]
     */
    private double topocentricElevationAngle;

    /*
     * atmospheric refraction correction [degrees]
     */
    private double atmosphericRefractionCorrection;

    /*
     * topocentric elevation angle (corrected) [degrees]
     */
    private double topocentricElevationAngleCorrected;

    /*
     * equation of time [minutes]
     */
    private double equationOfTime;

    /*
     * topocentric zenith angle [degrees]
     */
    private double topocentricZenithAngle;

    /*
     * topocentric azimuth angle (westward from south) [-180 to 180 degrees]
     */
    private double topocentricAzimuthAngleWestwardFromSouth;

    /*
     * topocentric azimuth angle (eastward from north) [ 0 to 360 degrees]
     */
    private double topocentricAzimuthAngleEastwardFromNorth;

    /*
     * surface incidence angle [degrees]
     */
    private double surfaceIncidenceAngle;

    /*
     * local sunrise time (+/- 30 seconds) [fractional hour]
     */
    private double localSunriseTime;

    /*
     * local sunset time (+/- 30 seconds) [fractional hour]
     */
    private double localSunsetTime;

    /*
     * local sun transit time (or solar noon) [fractional hour]
     */
    private double localSunTransitTime;

    /*
     * sunrise hour angle [degrees]
     */
    private double sunriseHourAngle;

    /*
     * sunset hour angle [degrees]
     */
    private double sunsetHourAngle;

    /*
     * sun transit altitude [degrees]
     */
    private double sunTransitAltitude;

    public SolarPositionAlgorithmSolverSolution() {

    }

    public SolarPositionAlgorithmSolverSolution(SolarPositionAlgorithmSolverSolution source) {
	this.julianDay = source.julianDay;
	this.julianCentury = source.julianCentury;
	this.julianEphemerisDay = source.julianEphemerisDay;
	this.julianEphemerisCentury = source.julianEphemerisCentury;
	this.julianEphemerisMillenium = source.julianEphemerisMillenium;
	this.earthHeliocentricLongitude = source.earthHeliocentricLongitude;
	this.earthHeliocentricLatitude = source.earthHeliocentricLatitude;
	this.earthRadiusVector = source.earthRadiusVector;
	this.geocentricLongitude = source.geocentricLongitude;
	this.geocentricLatitude = source.geocentricLatitude;
	this.meanElongationMoonSun = source.meanElongationMoonSun;
	this.meanAnomalySun = source.meanAnomalySun;
	this.meanAnomalyMoon = source.meanAnomalyMoon;
	this.argumentLatitudeMoon = source.argumentLatitudeMoon;
	this.ascendingLongitudeMoon = source.ascendingLongitudeMoon;
	this.nutationLongitude = source.nutationLongitude;
	this.nutationObliquity = source.nutationObliquity;
	this.eclipticMeanObliquity = source.eclipticMeanObliquity;
	this.eclipticTrueObliquity = source.eclipticTrueObliquity;
	this.aberrationCorrection = source.aberrationCorrection;
	this.apparentSunLongitude = source.apparentSunLongitude;
	this.greenwichMeanSiderealTime = source.greenwichMeanSiderealTime;
	this.greenwichSiderealTime = source.greenwichSiderealTime;
	this.geocentricSunRightAscension = source.geocentricSunRightAscension;
	this.geocentricSunDeclination = source.geocentricSunDeclination;
	this.observerHourAngle = source.observerHourAngle;
	this.sunEquatorialHorizontalParallax = source.sunEquatorialHorizontalParallax;
	this.sunRightAscensionParallax = source.sunRightAscensionParallax;
	this.topocentricSunDeclination = source.topocentricSunDeclination;
	this.topocentricSunRightAscension = source.topocentricSunDeclination;
	this.topocentricLocalHourAngle = source.topocentricSunDeclination;
	this.topocentricElevationAngle = source.topocentricElevationAngle;
	this.atmosphericRefractionCorrection = source.atmosphericRefractionCorrection;
	this.topocentricElevationAngleCorrected = source.topocentricElevationAngleCorrected;
	this.topocentricZenithAngle = source.topocentricZenithAngle;
	this.topocentricAzimuthAngleWestwardFromSouth = source.topocentricAzimuthAngleWestwardFromSouth;
	this.topocentricAzimuthAngleEastwardFromNorth = source.topocentricAzimuthAngleEastwardFromNorth;
	this.surfaceIncidenceAngle = source.surfaceIncidenceAngle;
	this.localSunriseTime = source.localSunriseTime;
	this.localSunsetTime = source.localSunsetTime;
	this.localSunTransitTime = source.localSunTransitTime;
	this.equationOfTime = source.equationOfTime;
	this.sunriseHourAngle = source.sunriseHourAngle;
	this.sunsetHourAngle = source.sunsetHourAngle;
	this.sunTransitAltitude = source.sunTransitAltitude;
    }

    public void setJulianDay(double julianDay) {
	this.julianDay = julianDay;
    }

    public double getJulianDay() {
	return julianDay;
    }

    public void setJulianCentury(double julianCentury) {
	this.julianCentury = julianCentury;
    }

    public double getJulianCentury() {
	return julianCentury;
    }

    public void setJulianEphemerisDay(double julianEphemerisDay) {
	this.julianEphemerisDay = julianEphemerisDay;
    }

    public double getJulianEphemerisDay() {
	return julianEphemerisDay;
    }

    public void setJulianEphemerisCentury(double julianEphemerisCentury) {
	this.julianEphemerisCentury = julianEphemerisCentury;
    }

    public double getJulianEphemerisCentury() {
	return julianEphemerisCentury;
    }

    public void setJulianEphemerisMillenium(double julianEphemerisMillenium) {
	this.julianEphemerisMillenium = julianEphemerisMillenium;
    }

    public double getJulianEphemerisMillenium() {
	return julianEphemerisMillenium;
    }

    public void setEarthHeliocentricLongitude(double earthHeliocentricLongitude) {
	this.earthHeliocentricLongitude = earthHeliocentricLongitude;
    }

    public double getEarthHeliocentricLongitude() {
	return earthHeliocentricLongitude;
    }

    public void setEarthHeliocentricLatitude(double earthHeliocentricLatitude) {
	this.earthHeliocentricLatitude = earthHeliocentricLatitude;
    }

    public double getEarthHeliocentricLatitude() {
	return earthHeliocentricLatitude;
    }

    public void setEarthRadiusVector(double earthRadiusVector) {
	this.earthRadiusVector = earthRadiusVector;
    }

    public double getEarthRadiusVector() {
	return earthRadiusVector;
    }

    public void setGeocentricLongitude(double geocentricLongitude) {
	this.geocentricLongitude = geocentricLongitude;
    }

    public double getGeocentricLongitude() {
	return geocentricLongitude;
    }

    public void setGeocentricLatitude(double geocentricLatitude) {
	this.geocentricLatitude = geocentricLatitude;
    }

    public double getGeocentricLatitude() {
	return geocentricLatitude;
    }

    public void setMeanElongationMoonSun(double meanElongationMoonSun) {
	this.meanElongationMoonSun = meanElongationMoonSun;
    }

    public double getMeanElongationMoonSun() {
	return meanElongationMoonSun;
    }

    public void setMeanAnomalySun(double meanAnomalySun) {
	this.meanAnomalySun = meanAnomalySun;
    }

    public double getMeanAnomalySun() {
	return meanAnomalySun;
    }

    public void setMeanAnomalyMoon(double meanAnomalyMoon) {
	this.meanAnomalyMoon = meanAnomalyMoon;
    }

    public double getMeanAnomalyMoon() {
	return meanAnomalyMoon;
    }

    public void setArgumentLatitudeMoon(double argumentLatitudeMoon) {
	this.argumentLatitudeMoon = argumentLatitudeMoon;
    }

    public double getArgumentLatitudeMoon() {
	return argumentLatitudeMoon;
    }

    public void setAscendingLongitudeMoon(double ascendingLongitudeMoon) {
	this.ascendingLongitudeMoon = ascendingLongitudeMoon;
    }

    public double getAscendingLongitudeMoon() {
	return ascendingLongitudeMoon;
    }

    public void setNutationLongitude(double nutationLongitude) {
	this.nutationLongitude = nutationLongitude;
    }

    public double getNutationLongitude() {
	return nutationLongitude;
    }

    public void setNutationObliquity(double nutationObliquity) {
	this.nutationObliquity = nutationObliquity;
    }

    public double getNutationObliquity() {
	return nutationObliquity;
    }

    public void setEclipticMeanObliquity(double eclipticMeanObliquity) {
	this.eclipticMeanObliquity = eclipticMeanObliquity;
    }

    public double getEclipticMeanObliquity() {
	return eclipticMeanObliquity;
    }

    public void setEclipticTrueobliquity(double eclipticTrueObliquity) {
	this.eclipticTrueObliquity = eclipticTrueObliquity;
    }

    public double getEclipticTrueObliquity() {
	return eclipticTrueObliquity;
    }

    public void setAberrationCorrection(double aberrationCorrection) {
	this.aberrationCorrection = aberrationCorrection;
    }

    public double getAberrationCorrection() {
	return aberrationCorrection;
    }

    public void setApparentSunLongitude(double apparentSunLongitude) {
	this.apparentSunLongitude = apparentSunLongitude;
    }

    public double getApparentSunLongitude() {
	return apparentSunLongitude;
    }

    public void setGreenwichMeanSiderealTime(double greenwichMeanSiderealTime) {
	this.greenwichMeanSiderealTime = greenwichMeanSiderealTime;
    }

    public double getGreenwichMeanSiderealTime() {
	return greenwichMeanSiderealTime;
    }

    public void setGreenwichSiderealTime(double greenwichSiderealTime) {
	this.greenwichSiderealTime = greenwichSiderealTime;
    }

    public double getGreenwichSiderealTime() {
	return greenwichSiderealTime;
    }

    public void setGeocentricSunRightAscension(double geocentricSunRightAscension) {
	this.geocentricSunRightAscension = geocentricSunRightAscension;
    }

    public double getGeocentricSunRightAscension() {
	return geocentricSunRightAscension;
    }

    public void setGeocentricSunDeclination(double geocentricSunDeclination) {
	this.geocentricSunDeclination = geocentricSunDeclination;
    }

    public double getGeocentricSunDeclination() {
	return geocentricSunDeclination;
    }

    public void setObserverHourAngle(double observerHourAngle) {
	this.observerHourAngle = observerHourAngle;
    }

    public double getObserverHourAngle() {
	return observerHourAngle;
    }

    public void setSunEquatorialHorizontalParallax(double sunEquatorialHorizontalParallax) {
	this.sunEquatorialHorizontalParallax = sunEquatorialHorizontalParallax;
    }

    public double getSunEquatorialHorizontalParallax() {
	return sunEquatorialHorizontalParallax;
    }

    public void setSunRightAscensionParallax(double sunRightAscensionParallax) {
	this.sunRightAscensionParallax = sunRightAscensionParallax;
    }

    public double getSunRightAscensionParallax() {
	return sunRightAscensionParallax;
    }

    public void setTopocentricSunDeclination(double topocentricSunDeclination) {
	this.topocentricSunDeclination = topocentricSunDeclination;
    }

    public double getTopocentricSunDeclination() {
	return topocentricSunDeclination;
    }

    public void setTopocentricSunRightAscension(double topocentricSunRightAscension) {
	this.topocentricSunRightAscension = topocentricSunRightAscension;
    }

    public double getTopocentricSunRightAscension() {
	return topocentricSunRightAscension;
    }

    public void setTopocentricLocalHourAngle(double topocentricLocalHourAngle) {
	this.topocentricLocalHourAngle = topocentricLocalHourAngle;
    }

    public double getTopocentricLocalHourAngle() {
	return topocentricLocalHourAngle;
    }

    public void setTopocentricElevationAngle(double topocentricElevationAngle) {
	this.topocentricElevationAngle = topocentricElevationAngle;
    }

    public double getTopocentricElevationAngle() {
	return topocentricElevationAngle;
    }

    public void setAtmosphericRefractionCorrection(double atmosphericRefractionCorrection) {
	this.atmosphericRefractionCorrection = atmosphericRefractionCorrection;
    }

    public double getAtmosphericRefractionCorrection() {
	return atmosphericRefractionCorrection;
    }

    public void setTopocentricElevationAngleCorrected(double topocentricElevationAngleCorrected) {
	this.topocentricElevationAngleCorrected = topocentricElevationAngleCorrected;
    }

    public double getTopocentricElevationAngleCorrected() {
	return topocentricElevationAngleCorrected;
    }

    public void setTopocentricZenithAngle(double topocentricZenithAngle) {
	this.topocentricZenithAngle = topocentricZenithAngle;
    }

    public double getTopocentricZenithAngle() {
	return topocentricZenithAngle;
    }

    public void setTopocentricAzimuthAngleWestwardFromSouth(double topocentricAzimuthAngleWestwardFromSouth) {
	this.topocentricAzimuthAngleWestwardFromSouth = topocentricAzimuthAngleWestwardFromSouth;
    }

    public double getTopocentricAzimuthAngleWestwardFromSouth() {
	return topocentricAzimuthAngleWestwardFromSouth;
    }

    public void setTopocentricAzimuthAngleEastwardFromNorth(double topocentricAzimuthAngleEastwardFromNorth) {
	this.topocentricAzimuthAngleEastwardFromNorth = topocentricAzimuthAngleEastwardFromNorth;
    }

    public double getTopocentricAzimuthAngleEastwardFromNorth() {
	return topocentricAzimuthAngleEastwardFromNorth;
    }

    public void setSurfaceIncidenceAngle(double surfaceIncidenceAngle) {
	this.surfaceIncidenceAngle = surfaceIncidenceAngle;
    }

    public double getSurfaceIncidenceAngle() {
	return surfaceIncidenceAngle;
    }

    public void setLocalSunriseTime(Double localSunriseTime) {
	this.localSunriseTime = localSunriseTime;
    }

    public double getLocalSunriseTime() {
	return localSunriseTime;
    }

    public void setLocalSunsetTime(Double localSunsetTime) {
	this.localSunsetTime = localSunsetTime;
    }

    public double getLocalSunsetTime() {
	return localSunsetTime;
    }

    public void setLocalSunTransitTime(Double localSunTransitTime) {
	this.localSunTransitTime = localSunTransitTime;
    }

    public double getLocalSunTransitTime() {
	return localSunTransitTime;
    }

    public void setEquationOfTime(double equationOfTime) {
	this.equationOfTime = equationOfTime;
    }

    public double getEquationOfTime() {
	return equationOfTime;
    }

    public void setSunriseHourAngle(Double sunriseHourAngle) {
	this.sunriseHourAngle = sunriseHourAngle;
    }

    public double getSunriseHourAngle() {
	return sunriseHourAngle;
    }

    public void setSunsetHourAngle(Double sunsetHourAngle) {
	this.sunsetHourAngle = sunsetHourAngle;
    }

    public double getSunsetHourAngle() {
	return sunsetHourAngle;
    }

    public void setSunTransitAltitude(Double sunTransitAltitude) {
	this.sunTransitAltitude = sunTransitAltitude;
    }

    public double getSunTransitAltitude() {
	return sunTransitAltitude;
    }

}
