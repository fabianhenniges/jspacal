/**
 @COPYRIGHT@
 */
package com.github.jspacal.units;

public class Length {
    private double value;
    private LengthUnit unit;

    public Length(double value, LengthUnit unit) {
	this.value = value;
	this.unit = unit;
    }

    public double inMeters() {
	return value * unit.toMeterFactor();
    }

    public double inAU() {
	return value * unit.toAUFactor();
    }

    @Override
    public String toString() {
	return value + " " + unit;
    }
}
