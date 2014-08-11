/**
 @COPYRIGHT@
 */
package com.github.jspacal.coordinates;

import com.github.junits.angle.AngleValue;
import com.github.junits.length.LengthValue;

public class EclipticCoordinates {
    private AngleValue longitude;
    public AngleValue latitude;
    public LengthValue distance;

    public EclipticCoordinates(AngleValue longitude, AngleValue latitude,
	    LengthValue distance) {
	this.longitude = longitude;
	this.latitude = latitude;
	this.distance = distance;
    }

    public AngleValue longitude() {
	return longitude;
    }

    public AngleValue latitude() {
	return latitude;
    }

    public LengthValue distance() {
	return distance;
    }
}
