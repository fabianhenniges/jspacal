/**
 @COPYRIGHT@
 */
package com.github.jspacal.testing;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.github.jspacal.SolarPositionCalculator;
import com.github.junits.angle.AngleUnit;
import com.github.junits.angle.AngleValue;
import com.github.junits.length.LengthUnit;
import com.github.junits.length.LengthValue;

public class JSPACalTesting {

    public static void main(String[] args) {
	AngleValue longitude = new AngleValue(18.45631, AngleUnit.DEGREE);
	AngleValue latitude = new AngleValue(54.384251, AngleUnit.DEGREE);
	LengthValue altitude = new LengthValue(36.0, LengthUnit.METER);
	SolarPositionCalculator solarCalculator = new SolarPositionCalculator(longitude, latitude, altitude);
	DateTime datetime = new DateTime(2009, 6, 30, 19, 0, 0, DateTimeZone.UTC);

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
	System.out.println("Local sunrise time (+/- 30 seconds) [datetime]: "
		+ solarCalculator.getLocalSolarTime().forLocalDate(datetime.toLocalDate()).sunriseTime().asDateTime());
	System.out.println("Local sun transit time (or solar noon): "
		+ solarCalculator.getLocalSolarTime().forDateTime(datetime).suntransitTime().asFractionalHourOfDay());
	System.out.println("Local sunset time (+/- 30 seconds) [fractional hour]: "
		+ solarCalculator.getLocalSolarTime().forDateTime(datetime).sunsetTime().asFractionalHourOfDay());
	System.out.println("Local sunset time (+/- 30 seconds) [datetime]: "
		+ solarCalculator.getLocalSolarTime().forDateTime(datetime).sunsetTime().asDateTime());

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
