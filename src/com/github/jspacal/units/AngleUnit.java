/**
 @COPYRIGHT@
 */
package com.github.jspacal.units;

public enum AngleUnit {
    DEGREE("deg", "degree", 2.0 * Math.PI / 360.0, 1.0, 3600.0), RADIAN("rad", "radian", 1.0, 360.0 / (2.0 * Math.PI),
	    360.0 * 3600.0 / (2.0 * Math.PI)), ARCSEC("arcsec", "second of arc", 2.0 * Math.PI / (360.0 * 3600.0),
	    1.0 / 3600.0, 1.0);

    private String symbol;
    private String name;
    private double toRadianFactor;
    private double toDegreeFactor;
    private double toArcsecFactor;

    private AngleUnit(String symbol, String name, double toRadianFactor, double toDegreeFactor, double toArcsecFactor) {
	this.symbol = symbol;
	this.name = name;
	this.toRadianFactor = toRadianFactor;
	this.toDegreeFactor = toDegreeFactor;
	this.toArcsecFactor = toArcsecFactor;
    }

    public double toRadianFactor() {
	return toRadianFactor;
    }

    public double toDegreeFactor() {
	return toDegreeFactor;
    }

    public double toArcsecFactor() {
	return toArcsecFactor;
    }

    @Override
    public String toString() {
	return "[" + symbol + "]";
    }
}
