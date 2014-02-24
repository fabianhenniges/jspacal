/**
 @COPYRIGHT@
 */
package com.github.jspacal.position.solar;

import com.github.jspacal.algorithm.SolarPositionAlgorithmSolverSolution;

public class SolarPosition {
    private SolarPositionAlgorithmSolverSolution solution;

    public SolarPosition(SolarPositionAlgorithmSolverSolution solution) {
	this.solution = solution;
    }

    public GeocentricSolarPosition geocentric() {
	return new GeocentricSolarPosition(solution);
    }

    public TopocentricSolarPosition topocentric() {
	return new TopocentricSolarPosition(solution);
    }
}
