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
	DateTime datetime = new DateTime(2014, 2, 21, 10, 0, 0, DateTimeZone.UTC);

	System.out.println("Topocentric zenith angle: "
		+ solarCalculator.getSolarPosition().forDateTime(datetime).topocentric().inHorizontalCoordiantes()
			.zenith().inDegrees());
	System.out.println("Topocentric elevation angle : "
		+ solarCalculator.getSolarPosition().forDateTime(datetime).topocentric().inHorizontalCoordiantes()
			.altitude());
	System.out.println("Topocentric azimuth angle (eastward from north) [0 to 360 degrees]: "
		+ solarCalculator.getSolarPosition().forDateTime(datetime).topocentric().inHorizontalCoordiantes()
			.azimuth().eastwardFromNorth());
	System.out.println("Topocentric azimuth angle (westward from south) [-180 to 180 degrees]: "
		+ solarCalculator.getSolarPosition().forDateTime(datetime).topocentric().inHorizontalCoordiantes()
			.azimuth().westwardFromSouth());
	System.out.println("Surface incidence angle: " + solarCalculator.surfaceIncidenceAngle(datetime));
	System.out.println("Local sunrise time (+/- 30 seconds) [fractional hour]: "
		+ solarCalculator.getLocalSolarTime().forLocalDate(datetime.toLocalDate()).sunriseTime()
			.asFractionalHourOfDay());
	System.out.println("Local sun transit time (or solar noon): "
		+ solarCalculator.getLocalSolarTime().forDateTime(datetime).suntransitTime().asFractionalHourOfDay());
	System.out.println("Local sunset time (+/- 30 seconds): "
		+ solarCalculator.getLocalSolarTime().forDateTime(datetime).sunsetTime().asFractionalHourOfDay());

	System.out.println("Topocentric sunrise altitude: "
		+ solarCalculator.getSolarPosition().atSunrise(datetime.toLocalDate()).topocentric()
			.inHorizontalCoordiantes().altitude());
	System.out.println("Topocentric sunrise azimuth angle: "
		+ solarCalculator.getSolarPosition().atSunrise(datetime.toLocalDate()).topocentric()
			.inHorizontalCoordiantes().azimuth().eastwardFromNorth());

	System.out.println("Topocentric sunset altitude: "
		+ solarCalculator.getSolarPosition().atSunset(datetime.toLocalDate()).topocentric()
			.inHorizontalCoordiantes().altitude());
	System.out.println("Topocentric sunset azimuth angle: "
		+ solarCalculator.getSolarPosition().atSunset(datetime.toLocalDate()).topocentric()
			.inHorizontalCoordiantes().azimuth().eastwardFromNorth());
    }

}
