/**
 @COPYRIGHT@
 */
package com.github.jspacal.position.solar;

import com.github.jspacal.Azimuth;
import com.github.jspacal.algorithm.SolarPositionAlgorithmSolverSolution;
import com.github.jspacal.coordinates.EquatorialCoordinates;
import com.github.jspacal.coordinates.HorizontalCoordiantes;
import com.github.jspacal.units.Angle;
import com.github.jspacal.units.AngleUnit;

public class TopocentricSolarPosition {
    private SolarPositionAlgorithmSolverSolution solution;

    public TopocentricSolarPosition(SolarPositionAlgorithmSolverSolution solution) {
	this.solution = solution;
    }

    public HorizontalCoordiantes inHorizontalCoordiantes() {
	Angle altitude = new Angle(solution.getTopocentricElevationAngleCorrected(), AngleUnit.DEGREE);
	Angle zenith = new Angle(solution.getTopocentricZenithAngle(), AngleUnit.DEGREE);
	Azimuth azimuth = new Azimuth(new Angle(solution.getTopocentricAzimuthAngleWestwardFromSouth(),
		AngleUnit.DEGREE), new Angle(solution.getTopocentricAzimuthAngleEastwardFromNorth(), AngleUnit.DEGREE));
	return new HorizontalCoordiantes(altitude, zenith, azimuth);
    }

    public EquatorialCoordinates inEquatorialCoordinates() {
	Angle rightAscension = new Angle(solution.getTopocentricSunRightAscension(), AngleUnit.DEGREE);
	Angle hourAngle = new Angle(solution.getTopocentricLocalHourAngle(), AngleUnit.DEGREE);
	Angle declination = new Angle(solution.getTopocentricSunDeclination(), AngleUnit.DEGREE);
	return new EquatorialCoordinates(rightAscension, hourAngle, declination);
    }
}
