/**
 @COPYRIGHT@
 */
package com.github.jspacal.testing;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.github.jspacal.SolarPositionCalculator;

public class JSPACalTesting {

    public static void main(String[] args) {
	SolarPositionCalculator solarCalculator = new SolarPositionCalculator(-105.178, 39.743, 1829);
	DateTime datetime = new DateTime(2014, 2, 18, 10, 0, 0, 0, DateTimeZone.UTC);

	System.out.println("Topocentric zenith angle [degrees]: "
		+ solarCalculator.calculateTopocentricZenithAngle(datetime));
	System.out.println("Topocentric elevation angle [degrees]: "
		+ solarCalculator.calculateTopocentricElevationAngle(datetime));
	System.out.println("Topocentric azimuth angle (eastward from north) [0 to 360 degrees]: "
		+ solarCalculator.calculateTopocentricAzimuthAngle(datetime));
	System.out.println("Topocentric azimuth angle (westward from south) [-180 to 180 degrees]: "
		+ solarCalculator.calculateTopocentricAzmiuthAngleWestFromSouth(datetime));
	System.out.println("Surface incidence angle [degrees]: "
		+ solarCalculator.calculateSurfaceIncidenceAngle(datetime));
	System.out.println("Local sunrise time (+/- 30 seconds) [fractional hour]: "
		+ solarCalculator.calculateLocalSunriseTime(datetime.toLocalDate()));
	System.out.println("Local sun transit time (or solar noon) [fractional hour]: "
		+ solarCalculator.calculateLocalSuntransitTime(datetime.toLocalDate()));
	System.out.println("Local sunset time (+/- 30 seconds) [fractional hour]: "
		+ solarCalculator.calculateLocalSunsetTime(datetime.toLocalDate()));
    }

}
