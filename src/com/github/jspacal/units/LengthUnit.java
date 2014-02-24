/**
 @COPYRIGHT@
 */
package com.github.jspacal.units;

public enum LengthUnit {
    METER("m", "meter", 1.0, 1.0 / 149597870700.0), AU("AU", "astronomical unit", 149597870700.0, 1.0);

    private String symbol;
    private String name;
    private double toMeterFactor;
    private double toAUFactor;

    private LengthUnit(String symbol, String name, double toMeterFactor, double toAUFactor) {
	this.symbol = symbol;
	this.name = name;
	this.toMeterFactor = toMeterFactor;
	this.toAUFactor = toAUFactor;
    }

    public double toMeterFactor() {
	return toMeterFactor;
    }

    public double toAUFactor() {
	return toAUFactor;
    }

    @Override
    public String toString() {
	return "[" + symbol + "]";
    }
}
