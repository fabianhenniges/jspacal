/**
 @COPYRIGHT@
 */
package com.github.jspacal;

import com.github.jlog.Logger;

public class SolarPositionAlgorithmParameters {
    private static final Logger LOGGER = Logger.getLogger(SolarPositionAlgorithmParameters.class.getName());

    /*
     * 4-digit year
     */
    private int year;
    private static final int YEAR_MIN = -2000;
    private static final int YEAR_MAX = 6000;

    /*
     * 2-digit monthOfYear
     */
    private int monthOfYear;
    private static final int MONTH_OF_YEAR_MIN = 1;
    private static final int MONTH_OF_YEAR_MAX = 12;

    /*
     * 2-digit day of monthOfYear
     */
    private int dayOfMonth;
    private static final int DAY_OF_MONTH_MIN = 1;
    private static final int DAY_OF_MONTH_MAX = 31;

    /*
     * observer local hour of day
     */
    private int hourOfDay;
    private static final int HOUR_OF_DAY_MIN = 0;
    private static final int HOUR_OF_DAY_MAX = 24;

    /*
     * observer local minuteOfHour
     */
    private int minuteOfHour;
    private static final int MINUTE_OF_HOUR_MIN = 0;
    private static final int MINUTE_OF_HOUR_MAX = 59;

    /*
     * observer local secondOfMinute
     */
    private int secondOfMinute;
    private static final int SECOND_OF_MINUTE_MIN = 0;
    private static final int SECOND_OF_MINUTE_MAX = 59;

    /*
     * observer time zone (negative west of Greenwich)
     */
    private double timezone;
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

    public SolarPositionAlgorithmParameters() {
	this.slope = SLOPE_DEFAULT;
	this.pressure = PRESSURE_DEFAULT;
	this.temperature = TEMPERATURE_DEFAULT;
	this.atmosphericRefraction = ATMOSPHERIC_REFRACTION_DEFAULT;
	this.deltaT = DELTA_T_DEFAULT;
	this.azimuthRotation = AZIMUTH_ROTATION_DEFAULT;
    }

    public SolarPositionAlgorithmParameters(int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minuteOfHour,
	    int second, double timezone, double longitude, double latitude, double altitude) {
	this.year = year;
	this.monthOfYear = monthOfYear;
	this.dayOfMonth = dayOfMonth;
	this.hourOfDay = hourOfDay;
	this.minuteOfHour = minuteOfHour;
	this.secondOfMinute = second;
	this.timezone = timezone;
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

    public void setYear(int year) {
	this.year = year;
    }

    public int getYear() {
	return year;
    }

    public void setMonthOfYear(int monthOfYear) {
	this.monthOfYear = monthOfYear;
    }

    public int getMonthOfYear() {
	return monthOfYear;
    }

    public void setDayOfMonth(int dayOfMonth) {
	this.dayOfMonth = dayOfMonth;
    }

    public int getDayOfMonth() {
	return dayOfMonth;
    }

    public void setHourOfDay(int hourOfDay) {
	this.hourOfDay = hourOfDay;
    }

    public int getHourOfDay() {
	return hourOfDay;
    }

    public void setMinuteOfHour(int minuteOfHour) {
	this.minuteOfHour = minuteOfHour;
    }

    public int getMinuteOfHour() {
	return minuteOfHour;
    }

    public void setSecondOfMinute(int secondOfMinute) {
	this.secondOfMinute = secondOfMinute;
    }

    public int getSecondOfMinute() {
	return secondOfMinute;
    }

    public void setTimezone(double timezone) {
	this.timezone = timezone;
    }

    public double getTimezone() {
	return timezone;
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

    public boolean isValid() {
	if (year < YEAR_MIN || year > YEAR_MAX) {
	    LOGGER.severe("[jspcal] {} is not valid year", year);
	    return false;
	}

	if (monthOfYear < MONTH_OF_YEAR_MIN || monthOfYear > MONTH_OF_YEAR_MAX) {
	    LOGGER.severe("[jspcal] {} is not valid month of year", monthOfYear);
	    return false;
	}

	if (dayOfMonth < DAY_OF_MONTH_MIN || dayOfMonth > DAY_OF_MONTH_MAX) {
	    LOGGER.severe("[jspcal] {} is not valid day of month", dayOfMonth);
	    return false;
	}

	if (hourOfDay < HOUR_OF_DAY_MIN || hourOfDay > HOUR_OF_DAY_MAX) {
	    LOGGER.severe("[jspcal] {} is not valid hour of day", hourOfDay);
	    return false;
	}

	if (minuteOfHour < MINUTE_OF_HOUR_MIN || minuteOfHour > MINUTE_OF_HOUR_MAX) {
	    LOGGER.severe("[jspcal] {} is not valid minute of hour", minuteOfHour);
	    return false;
	}

	if (secondOfMinute < SECOND_OF_MINUTE_MIN || secondOfMinute > SECOND_OF_MINUTE_MAX) {
	    LOGGER.severe("[jspcal] {} is not valid second of minute", secondOfMinute);
	    return false;
	}

	if (timezone < TIMEZONE_MIN || timezone > TIMEZONE_MAX) {
	    LOGGER.severe("[jspcal] {} is not valid timezone", timezone);
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

	if (atmosphericRefraction < ATMOSPHERIC_REFRACTION_MIN || atmosphericRefraction > ATMOSPHERIC_REFRACTION_MAX) {
	    LOGGER.severe("[jspcal] {} is not valid atmospheric refraction", atmosphericRefraction);
	    return false;
	}

	if (deltaT < DELTA_T_MIN || deltaT > DELTA_T_MAX) {
	    LOGGER.severe("[jspcal] {} is not valid deltaT", deltaT);
	    return false;
	}

	if (azimuthRotation < AZIMUTH_ROTATION_MIN || azimuthRotation > AZIMUTH_ROTATION_MAX) {
	    LOGGER.severe("[jspcal] {} is not valid azimuth rotation", azimuthRotation);
	    return false;
	}

	return true;
    }
}
