/**
 @COPYRIGHT@
 */
package com.github.jspacal.position.solar;

import com.github.jspacal.algorithm.SolarPositionAlgorithmSolverSolution;
import com.github.jspacal.coordinates.EclipticCoordinates;
import com.github.jspacal.coordinates.EquatorialCoordinates;
import com.github.junits.angle.AngleUnit;
import com.github.junits.angle.AngleValue;
import com.github.junits.length.LengthUnit;
import com.github.junits.length.LengthValue;

public class GeocentricSolarPosition {
    private SolarPositionAlgorithmSolverSolution solution;

    public GeocentricSolarPosition(SolarPositionAlgorithmSolverSolution solution) {
	this.solution = solution;
    }

    public EclipticCoordinates inEclipticCoordinates() {
	AngleValue longitude = new AngleValue(
		solution.getGeocentricLongitude(), AngleUnit.DEGREE);
	AngleValue latitude = new AngleValue(solution.getGeocentricLatitude(),
		AngleUnit.DEGREE);
	LengthValue distance = new LengthValue(solution.getEarthRadiusVector(),
		LengthUnit.AU);
	return new EclipticCoordinates(longitude, latitude, distance);
    }

    public EquatorialCoordinates inEquatorialCoordinates() {
	AngleValue rightAscension = new AngleValue(
		solution.getGeocentricSunRightAscension(), AngleUnit.DEGREE);
	AngleValue hourAngle = new AngleValue(solution.getObserverHourAngle(),
		AngleUnit.DEGREE);// TODO?
	AngleValue declination = new AngleValue(
		solution.getGeocentricSunDeclination(), AngleUnit.DEGREE);
	return new EquatorialCoordinates(rightAscension, hourAngle, declination);
    }

}
