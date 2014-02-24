/**
 @COPYRIGHT@
 */
package com.github.jspacal.position.earth;

import com.github.jspacal.algorithm.SolarPositionAlgorithmSolverSolution;
import com.github.jspacal.coordinates.EclipticCoordinates;
import com.github.jspacal.units.Angle;
import com.github.jspacal.units.AngleUnit;
import com.github.jspacal.units.Length;
import com.github.jspacal.units.LengthUnit;

public class HeliocentricEarthPosition {
    private SolarPositionAlgorithmSolverSolution solution;

    public HeliocentricEarthPosition(SolarPositionAlgorithmSolverSolution solution) {
	this.solution = solution;
    }

    public EclipticCoordinates inEclipticCoordinates() {
	Angle longitude = new Angle(solution.getEarthHeliocentricLongitude(), AngleUnit.DEGREE);
	Angle latitude = new Angle(solution.getEarthHeliocentricLatitude(), AngleUnit.DEGREE);
	Length distance = new Length(solution.getEarthRadiusVector(), LengthUnit.AU);
	return new EclipticCoordinates(longitude, latitude, distance);
    }
}
