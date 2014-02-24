/**
 @COPYRIGHT@
 */
package com.github.jspacal.position.solar;

import com.github.jspacal.algorithm.SolarPositionAlgorithmSolverSolution;
import com.github.jspacal.coordinates.EclipticCoordinates;
import com.github.jspacal.coordinates.EquatorialCoordinates;
import com.github.jspacal.units.Angle;
import com.github.jspacal.units.AngleUnit;
import com.github.jspacal.units.Length;
import com.github.jspacal.units.LengthUnit;

public class GeocentricSolarPosition {
    private SolarPositionAlgorithmSolverSolution solution;

    public GeocentricSolarPosition(SolarPositionAlgorithmSolverSolution solution) {
	this.solution = solution;
    }

    public EclipticCoordinates inEclipticCoordinates() {
	Angle longitude = new Angle(solution.getGeocentricLongitude(), AngleUnit.DEGREE);
	Angle latitude = new Angle(solution.getGeocentricLatitude(), AngleUnit.DEGREE);
	Length distance = new Length(solution.getEarthRadiusVector(), LengthUnit.AU);
	return new EclipticCoordinates(longitude, latitude, distance);
    }

    public EquatorialCoordinates inEquatorialCoordinates() {
	Angle rightAscension = new Angle(solution.getGeocentricSunRightAscension(), AngleUnit.DEGREE);
	Angle hourAngle = new Angle(solution.getObserverHourAngle(), AngleUnit.DEGREE);// TODO?
	Angle declination = new Angle(solution.getGeocentricSunDeclination(), AngleUnit.DEGREE);
	return new EquatorialCoordinates(rightAscension, hourAngle, declination);
    }

}
