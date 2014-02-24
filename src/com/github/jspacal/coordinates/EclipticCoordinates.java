/**
 @COPYRIGHT@
 */
package com.github.jspacal.coordinates;

import com.github.jspacal.units.Angle;
import com.github.jspacal.units.Length;

public class EclipticCoordinates {
    private Angle longitude;
    public Angle latitude;
    public Length distance;

    public EclipticCoordinates(Angle longitude, Angle latitude, Length distance) {
	this.longitude = longitude;
	this.latitude = latitude;
	this.distance = distance;
    }

    public Angle longitude() {
	return longitude;
    }

    public Angle latitude() {
	return latitude;
    }

    public Length distance() {
	return distance;
    }
}
