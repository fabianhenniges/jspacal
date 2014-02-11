package com.github.jspacal;

public class SolarPositionAlgorithmParameters {

	/*
	 * 4-digit year
	 */
	private int year;
	private static final int YEAR_MIN = -2000;
	private static final int YEAR_MAX = 6000;

	/*
	 * 2-digit month
	 */
	private int month;
	private static final int MONTH_MIN = 1;
	private static final int MONTH_MAX = 12;

	/*
	 * 2-digit day of month
	 */
	private int dayOfMonth;
	private static final int DAY_MIN = 1;
	private static final int DAY_MAX = 31;

	/*
	 * observer local hour of day
	 */
	private int hourOfDay;
	private static final int HOUR_MIN = 0;
	private static final int HOUR_MAX = 24;

	/*
	 * observer local minute
	 */
	private int minute;
	private static final int MINUTE_MIN = 0;
	private static final int MINUTE_MAX = 59;

	/*
	 * observer local second
	 */
	private int second;
	private static final int SECOND_MIN = 0;
	private static final int SECOND_MAX = 59;

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
	 * observer elevation in meters
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
	private static final double PRESSURE_DEFAULT = 870.0;

	/*
	 * Annual average local temperature in Celsius
	 */
	private double temperature;
	private static final double TEMPERATURE_MIN = -273.0;
	private static final double TEMPERATURE_MAX = 6000.0;
	private static final double TEMPERATURE_DEFAULT = 20.0;

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
	private static final double DELTA_T_DEFAULT = 67.0;

	/*
	 * Surface azimuth rotation (measured from south to projection of surface
	 * normal on horizontal plane, negative west)
	 */
	private double azimuthRotation;
	private static final double AZIMUTH_ROTATION_MIN = -360.0;
	private static final double AZIMUTH_ROTATION_MAX = 360.0;
	private static final double AZIMUTH_ROTATION_DEFAULT = 0.0;

	public SolarPositionAlgorithmParameters(int year, int month,
			int dayOfMonth, int hourOfDay, int minute, int second,
			double timezone, double longitude, double latitude, double altitude) {
		this.year = year;
		this.month = month;
		this.dayOfMonth = dayOfMonth;
		this.hourOfDay = hourOfDay;
		this.minute = minute;
		this.second = second;
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

	public void setMonth(int month) {
		this.month = month;
	}

	public int getMonth() {
		return month;
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

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getMinute() {
		return minute;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getSecond() {
		return second;
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

}
