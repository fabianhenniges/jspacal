/**
 @COPYRIGHT@
 */
package com.github.jspacal.coordinates;

import com.github.jspacal.Azimuth;
import com.github.junits.angle.AngleValue;

public class HorizontalCoordiantes {
    private AngleValue altitude;
    private AngleValue zenith;
    private Azimuth azimuth;

    public HorizontalCoordiantes(AngleValue altitude, AngleValue zenith, Azimuth azimuth) {
	this.altitude = altitude;
	this.zenith = zenith;
	this.azimuth = azimuth;
    }

    public AngleValue altitude() {
	return altitude;
    }

    public AngleValue zenith() {
	return zenith;
    }

    public Azimuth azimuth() {
	return azimuth;
    }
}
