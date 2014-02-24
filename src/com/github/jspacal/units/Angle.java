/**
 @COPYRIGHT@
 */
package com.github.jspacal.units;

public class Angle {
    private double value;
    private AngleUnit unit;

    public Angle(double value, AngleUnit unit) {
	this.value = value;
	this.unit = unit;
    }

    public double inRadians() {
	return value * unit.toRadianFactor();
    }

    public double inDegrees() {
	return value * unit.toDegreeFactor();
    }

    public double inArcsec() {
	return value * unit.toArcsecFactor();
    }

    @Override
    public String toString() {
	return value + " " + unit;
    }
}
