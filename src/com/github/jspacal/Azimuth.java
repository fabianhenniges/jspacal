/**
 @COPYRIGHT@
 */
package com.github.jspacal;

import com.github.jspacal.units.Angle;

public class Azimuth {
    private Angle westwardFromSouth;
    private Angle eastwardFromNorth;

    public Azimuth(Angle westwardFromSouth, Angle eastwardFromNorth) {
	this.westwardFromSouth = westwardFromSouth;
	this.eastwardFromNorth = eastwardFromNorth;
    }

    public Angle westwardFromSouth() {
	return westwardFromSouth;
    }

    public Angle eastwardFromNorth() {
	return eastwardFromNorth;
    }
}
