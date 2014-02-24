/**
 @COPYRIGHT@
 */
package com.github.jspacal.coordinates;

import com.github.jspacal.Azimuth;
import com.github.jspacal.units.Angle;

public class HorizontalCoordiantes {
    private Angle altitude;
    private Angle zenith;
    private Azimuth azimuth;

    public HorizontalCoordiantes(Angle altitude, Angle zenith, Azimuth azimuth) {
	this.altitude = altitude;
	this.zenith = zenith;
	this.azimuth = azimuth;
    }

    public Angle altitude() {
	return altitude;
    }

    public Angle zenith() {
	return zenith;
    }

    public Azimuth azimuth() {
	return azimuth;
    }
}
