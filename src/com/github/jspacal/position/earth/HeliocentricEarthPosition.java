/**
 @COPYRIGHT@
 */
package com.github.jspacal.position.earth;

import com.github.jspacal.algorithm.SolarPositionAlgorithmSolverSolution;
import com.github.jspacal.coordinates.EclipticCoordinates;
import com.github.junits.angle.AngleUnit;
import com.github.junits.angle.AngleValue;
import com.github.junits.length.LengthUnit;
import com.github.junits.length.LengthValue;

public class HeliocentricEarthPosition {
    private SolarPositionAlgorithmSolverSolution solution;

    public HeliocentricEarthPosition(
	    SolarPositionAlgorithmSolverSolution solution) {
	this.solution = solution;
    }

    public EclipticCoordinates inEclipticCoordinates() {
	AngleValue longitude = new AngleValue(
		solution.getEarthHeliocentricLongitude(), AngleUnit.DEGREE);
	AngleValue latitude = new AngleValue(
		solution.getEarthHeliocentricLatitude(), AngleUnit.DEGREE);
	LengthValue distance = new LengthValue(solution.getEarthRadiusVector(),
		LengthUnit.AU);
	return new EclipticCoordinates(longitude, latitude, distance);
    }
}
