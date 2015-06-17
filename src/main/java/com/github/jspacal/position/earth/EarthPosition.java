/**
 @COPYRIGHT@
 */
package com.github.jspacal.position.earth;

import com.github.jspacal.algorithm.SolarPositionAlgorithmSolverSolution;

public class EarthPosition {
    private SolarPositionAlgorithmSolverSolution solution;

    public EarthPosition(SolarPositionAlgorithmSolverSolution solution) {
	this.solution = solution;
    }

    public HeliocentricEarthPosition heliocentric() {
	return new HeliocentricEarthPosition(solution);
    }
}
