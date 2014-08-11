/**
 @COPYRIGHT@
 */
package com.github.jspacal.coordinates;

import com.github.junits.angle.AngleValue;

public class EquatorialCoordinates {
    public AngleValue rightAscension;
    public AngleValue hourAngle;
    public AngleValue declination;

    public EquatorialCoordinates(AngleValue rightAscension,
	    AngleValue hourAngle, AngleValue declination) {
	this.rightAscension = rightAscension;
	this.hourAngle = hourAngle;
	this.declination = declination;
    }

    public AngleValue rightAscension() {
	return rightAscension;
    }

    public AngleValue hourAngle() {
	return hourAngle;
    }

    public AngleValue declination() {
	return declination;
    }

}
