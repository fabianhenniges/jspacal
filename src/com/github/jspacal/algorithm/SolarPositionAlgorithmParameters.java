/**
 @COPYRIGHT@
 */
package com.github.jspacal.algorithm;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalTime;

import com.github.jlog.Logger;

public class SolarPositionAlgorithmParameters {
    private static final Logger LOGGER = Logger
	    .getLogger(SolarPositionAlgorithmParameters.class.getName());

    private DateTime datetime;

    /*
     * 4-digit year
     */
    private static final int YEAR_MIN = -2000;
    private static final int YEAR_MAX = 6000;

    /*
     * 2-digit monthOfYear
     */
    private static final int MONTH_OF_YEAR_MIN = 1;
    private static final int MONTH_OF_YEAR_MAX = 12;

    /*
     * 2-digit day of monthOfYear
     */
    private static final int DAY_OF_MONTH_MIN = 1;
    private static final int DAY_OF_MONTH_MAX = 31;

    /*
     * observer local hour of day
     */
    private static final int HOUR_OF_DAY_MIN = 0;
    private static final int HOUR_OF_DAY_MAX = 24;

    /*
     * observer local minuteOfHour
     */
    private static final int MINUTE_OF_HOUR_MIN = 0;
    private static final int MINUTE_OF_HOUR_MAX = 59;

    /*
     * observer local secondOfMinute
     */
    private static final int SECOND_OF_MINUTE_MIN = 0;
    private static final int SECOND_OF_MINUTE_MAX = 59;

    /*
     * observer time zone (negative west of Greenwich)
     */
    private static final double TIMEZONE_MIN = -18.0;
    private static final double TIMEZONE_MAX = 18.0;

    /*
     * observer longitude (negative west of Greenwich)
     */
    private double longitude;
    private static final double LONGITUDE_MIN = -180.0;
    private static final double LONGITUDE_MAX = 180.0;

    /*
     * observer latitude (negative south of equator)
     */
    private double latitude;
    private static final double LATITUDE_MIN = -90.0;
    private static final double LATITUDE_MAX = 90.0;

    /*
     * observer altitude in meters
     */
    private double altitude;
    private static final double ALTITUDE_MIN = -6500000.0;

    /*
     * surface slope (measured from the horizontal plane)
     */
    private double slope;
    private static final double SLOPE_MIN = -360.0;
    private static final double SLOPE_MAX = 360.0;
    private static final double SLOPE_DEFAULT = 0.0;

    /*
     * Annual average local pressure in millibars
     */
    private double pressure;
    private static final double PRESSURE_MIN = 0.0;
    private static final double PRESSURE_MAX = 5000.0;
    private static final double PRESSURE_DEFAULT = 835.0;

    /*
     * Annual average local temperature in Celsius
     */
    private double temperature;
    private static final double TEMPERATURE_MIN = -273.0;
    private static final double TEMPERATURE_MAX = 6000.0;
    private static final double TEMPERATURE_DEFAULT = 10.0;

    /*
     * Atmospheric refraction at sunrise and sunset (0.5667 deg is typical)
     */
    private double atmosphericRefraction;
    private static final double ATMOSPHERIC_REFRACTION_MIN = -5.0;
    private static final double ATMOSPHERIC_REFRACTION_MAX = 5.0;
    private static final double ATMOSPHERIC_REFRACTION_DEFAULT = 0.5667;

    /*
     * Difference between earth rotation time and terrestrial time. It is
     * derived from observation only and is reported in this bulletin:
     * http://maia.usno.navy.mil/ser7/ser7.dat, where delta_t = 32.184 +
     * (TAI-UTC) + DUT1
     */
    private double deltaT;
    private static final double DELTA_T_MIN = -8000.0;
    private static final double DELTA_T_MAX = 8000.0;
    private static final double DELTA_T_DEFAULT = 65.0;

    /*
     * Surface azimuth rotation (measured from south to projection of surface
     * normal on horizontal plane, negative west)
     */
    private double azimuthRotation;
    private static final double AZIMUTH_ROTATION_MIN = -360.0;
    private static final double AZIMUTH_ROTATION_MAX = 360.0;
    private static final double AZIMUTH_ROTATION_DEFAULT = 0.0;

    public SolarPositionAlgorithmParameters(DateTime datetime,
	    double longitude, double latitude, double altitude) {
	this.datetime = datetime;

	this.longitude = longitude;
	this.latitude = latitude;
	this.altitude = altitude;

	this.slope = SLOPE_DEFAULT;
	this.pressure = PRESSURE_DEFAULT;
	this.temperature = TEMPERATURE_DEFAULT;
	this.atmosphericRefraction = ATMOSPHERIC_REFRACTION_DEFAULT;
	this.deltaT = DELTA_T_DEFAULT;
	this.azimuthRotation = AZIMUTH_ROTATION_DEFAULT;
    }

    public SolarPositionAlgorithmParameters(
	    SolarPositionAlgorithmParameters source) {
	this.datetime = source.datetime;

	this.longitude = source.longitude;
	this.latitude = source.latitude;
	this.altitude = source.altitude;

	this.slope = source.slope;
	this.pressure = source.pressure;
	this.temperature = source.temperature;
	this.atmosphericRefraction = source.atmosphericRefraction;
	this.deltaT = source.deltaT;
	this.azimuthRotation = source.azimuthRotation;
    }

    public int getYear() {
	return datetime.getYear();
    }

    public int getMonthOfYear() {
	return datetime.getMonthOfYear();
    }

    public int getDayOfMonth() {
	return datetime.getDayOfMonth();
    }

    public int getHourOfDay() {
	return datetime.getHourOfDay();
    }

    public void setHourOfDay(int hourOfDay) {
	this.datetime = datetime.toLocalDate().toDateTime(
		new LocalTime(hourOfDay, datetime.getMinuteOfHour(), datetime
			.getSecondOfMinute()));
    }

    public int getMinuteOfHour() {
	return datetime.getMinuteOfHour();
    }

    public void setMinuteOfHour(int minuteOfHour) {
	this.datetime = datetime.toLocalDate().toDateTime(
		new LocalTime(datetime.getHourOfDay(), minuteOfHour, datetime
			.getSecondOfMinute()));
    }

    public int getSecondOfMinute() {
	return datetime.getSecondOfMinute();
    }

    public void setSecondOfMinute(int secondOfMinute) {
	this.datetime = datetime.toLocalDate().toDateTime(
		new LocalTime(datetime.getHourOfDay(), datetime
			.getMinuteOfHour(), secondOfMinute));
    }

    public double getTimezone() {
	return datetime.getZone().getOffset(null) / 3600000.0;
    }

    public void setTimezone(double timezone) {
	this.datetime = datetime.toLocalDate().toDateTime(
		new LocalTime(datetime.getHourOfDay(),
			datetime.getMinuteOfHour(),
			datetime.getSecondOfMinute()),
		DateTimeZone.forOffsetHours((int) timezone));
    }

    public void setDateTime(DateTime datetime) {
	this.datetime = datetime;
    }

    public DateTime getDatetime() {
	return datetime;
    }

    public void setLongitude(double longitude) {
	this.longitude = longitude;
    }

    public double getLongitude() {
	return longitude;
    }

    public void setLatitude(double latitude) {
	this.latitude = latitude;
    }

    public double getLatitude() {
	return latitude;
    }

    public void setAltitude(double altitude) {
	this.altitude = altitude;
    }

    public double getAltitude() {
	return altitude;
    }

    public void setSlope(double slope) {
	this.slope = slope;
    }

    public double getSlope() {
	return slope;
    }

    public void setPressure(double pressure) {
	this.pressure = pressure;
    }

    public double getPressure() {
	return pressure;
    }

    public void setTemperature(double temperature) {
	this.temperature = temperature;
    }

    public double getTemperature() {
	return temperature;
    }

    public void setAtmosphericRefraction(double atmosphericRefraction) {
	this.atmosphericRefraction = atmosphericRefraction;
    }

    public double getAtmosphericRefraction() {
	return atmosphericRefraction;
    }

    public void setDeltaT(double deltaT) {
	this.deltaT = deltaT;
    }

    public double getDeltaT() {
	return deltaT;
    }

    public void setAzimuthRotation(double azimuthRotation) {
	this.azimuthRotation = azimuthRotation;
    }

    public double getAzimuthRotation() {
	return azimuthRotation;
    }

    public boolean areValid() {
	if (datetime.getYear() < YEAR_MIN || datetime.getYear() > YEAR_MAX) {
	    LOGGER.severe("[jspcal] {} is not valid year", datetime.getYear());
	    return false;
	}

	if (datetime.getMonthOfYear() < MONTH_OF_YEAR_MIN
		|| datetime.getMonthOfYear() > MONTH_OF_YEAR_MAX) {
	    LOGGER.severe("[jspcal] {} is not valid month of year",
		    datetime.getMonthOfYear());
	    return false;
	}

	if (datetime.getDayOfMonth() < DAY_OF_MONTH_MIN
		|| datetime.getDayOfMonth() > DAY_OF_MONTH_MAX) {
	    LOGGER.severe("[jspcal] {} is not valid day of month",
		    datetime.getDayOfMonth());
	    return false;
	}

	if (datetime.getHourOfDay() < HOUR_OF_DAY_MIN
		|| datetime.getHourOfDay() > HOUR_OF_DAY_MAX) {
	    LOGGER.severe("[jspcal] {} is not valid hour of day",
		    datetime.getHourOfDay());
	    return false;
	}

	if (datetime.getMinuteOfHour() < MINUTE_OF_HOUR_MIN
		|| datetime.getMinuteOfHour() > MINUTE_OF_HOUR_MAX) {
	    LOGGER.severe("[jspcal] {} is not valid minute of hour",
		    datetime.getMinuteOfHour());
	    return false;
	}

	if (datetime.getSecondOfMinute() < SECOND_OF_MINUTE_MIN
		|| datetime.getSecondOfMinute() > SECOND_OF_MINUTE_MAX) {
	    LOGGER.severe("[jspcal] {} is not valid second of minute",
		    datetime.getSecondOfMinute());
	    return false;
	}

	if (datetime.getZone().getOffset(null) / 3600000.0 < TIMEZONE_MIN
		|| datetime.getZone().getOffset(null) / 3600000.0 > TIMEZONE_MAX) {
	    LOGGER.severe("[jspcal] {} is not valid timezone", datetime
		    .getZone().getOffset(null) / 3600000.0);
	    return false;
	}

	if (longitude < LONGITUDE_MIN || longitude > LONGITUDE_MAX) {
	    LOGGER.severe("[jspcal] {} is not valid longitude", longitude);
	    return false;
	}

	if (latitude < LATITUDE_MIN || latitude > LATITUDE_MAX) {
	    LOGGER.severe("[jspcal] {} is not valid latitude", latitude);
	    return false;
	}

	if (altitude < ALTITUDE_MIN) {
	    LOGGER.severe("[jspcal] {} is not valid altitude", altitude);
	    return false;
	}

	if (slope < SLOPE_MIN || slope > SLOPE_MAX) {
	    LOGGER.severe("[jspcal] {} is not valid slope", slope);
	    return false;
	}

	if (pressure < PRESSURE_MIN || pressure > PRESSURE_MAX) {
	    LOGGER.severe("[jspcal] {} is not valid pressure", pressure);
	    return false;
	}

	if (temperature < TEMPERATURE_MIN || temperature > TEMPERATURE_MAX) {
	    LOGGER.severe("[jspcal] {} is not valid temperature", temperature);
	    return false;
	}

	if (atmosphericRefraction < ATMOSPHERIC_REFRACTION_MIN
		|| atmosphericRefraction > ATMOSPHERIC_REFRACTION_MAX) {
	    LOGGER.severe("[jspcal] {} is not valid atmospheric refraction",
		    atmosphericRefraction);
	    return false;
	}

	if (deltaT < DELTA_T_MIN || deltaT > DELTA_T_MAX) {
	    LOGGER.severe("[jspcal] {} is not valid deltaT", deltaT);
	    return false;
	}

	if (azimuthRotation < AZIMUTH_ROTATION_MIN
		|| azimuthRotation > AZIMUTH_ROTATION_MAX) {
	    LOGGER.severe("[jspcal] {} is not valid azimuth rotation",
		    azimuthRotation);
	    return false;
	}

	return true;
    }
}
