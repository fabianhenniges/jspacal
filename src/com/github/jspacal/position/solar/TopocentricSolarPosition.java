/**
 @COPYRIGHT@
 */
package com.github.jspacal.position.solar;

import com.github.jspacal.Azimuth;
import com.github.jspacal.algorithm.SolarPositionAlgorithmSolverSolution;
import com.github.jspacal.coordinates.EquatorialCoordinates;
import com.github.jspacal.coordinates.HorizontalCoordiantes;
import com.github.junits.angle.AngleUnit;
import com.github.junits.angle.AngleValue;

public class TopocentricSolarPosition {
    private SolarPositionAlgorithmSolverSolution solution;

    public TopocentricSolarPosition(SolarPositionAlgorithmSolverSolution solution) {
	this.solution = solution;
    }

    public HorizontalCoordiantes inHorizontalCoordiantes() {
	AngleValue altitude = new AngleValue(solution.getTopocentricElevationAngleCorrected(), AngleUnit.DEGREE);
	AngleValue zenith = new AngleValue(solution.getTopocentricZenithAngle(), AngleUnit.DEGREE);
	Azimuth azimuth = new Azimuth(new AngleValue(solution.getTopocentricAzimuthAngleWestwardFromSouth(),
		AngleUnit.DEGREE), new AngleValue(solution.getTopocentricAzimuthAngleEastwardFromNorth(),
		AngleUnit.DEGREE));
	return new HorizontalCoordiantes(altitude, zenith, azimuth);
    }

    public EquatorialCoordinates inEquatorialCoordinates() {
	AngleValue rightAscension = new AngleValue(solution.getTopocentricSunRightAscension(), AngleUnit.DEGREE);
	AngleValue hourAngle = new AngleValue(solution.getTopocentricLocalHourAngle(), AngleUnit.DEGREE);
	AngleValue declination = new AngleValue(solution.getTopocentricSunDeclination(), AngleUnit.DEGREE);
	return new EquatorialCoordinates(rightAscension, hourAngle, declination);
    }
}
