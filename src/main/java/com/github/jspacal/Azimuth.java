/**
 @COPYRIGHT@
 */
package com.github.jspacal;

import com.github.junits.angle.AngleValue;

public class Azimuth {
    private AngleValue westwardFromSouth;
    private AngleValue eastwardFromNorth;

    public Azimuth(AngleValue westwardFromSouth, AngleValue eastwardFromNorth) {
	this.westwardFromSouth = westwardFromSouth;
	this.eastwardFromNorth = eastwardFromNorth;
    }

    public AngleValue westwardFromSouth() {
	return westwardFromSouth;
    }

    public AngleValue eastwardFromNorth() {
	return eastwardFromNorth;
    }
}
