/**
 @COPYRIGHT@
 */
package com.github.jspacal.coordinates;

import com.github.jspacal.units.Angle;

public class EquatorialCoordinates {
    public Angle rightAscension;
    public Angle hourAngle;
    public Angle declination;

    public EquatorialCoordinates(Angle rightAscension, Angle hourAngle, Angle declination) {
	this.rightAscension = rightAscension;
	this.hourAngle = hourAngle;
	this.declination = declination;
    }

    public Angle rightAscension() {
	return rightAscension;
    }

    public Angle hourAngle() {
	return hourAngle;
    }

    public Angle declination() {
	return declination;
    }

}
