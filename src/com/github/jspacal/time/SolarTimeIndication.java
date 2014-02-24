/**
 @COPYRIGHT@
 */
package com.github.jspacal.time;

import org.joda.time.LocalDate;

import com.github.jspacal.algorithm.SolarPositionAlgorithmSolverSolution;

public class SolarTimeIndication {
    private LocalDate localdate;
    private SolarPositionAlgorithmSolverSolution solution;

    public SolarTimeIndication(LocalDate localdate, SolarPositionAlgorithmSolverSolution solution) {
	this.localdate = localdate;
	this.solution = solution;
    }

    public SolarTime sunriseTime() {
	return new SolarTime(localdate, solution.getLocalSunriseTime());
    }

    public SolarTime suntransitTime() {
	return new SolarTime(localdate, solution.getLocalSunTransitTime());
    }

    public SolarTime sunsetTime() {
	return new SolarTime(localdate, solution.getLocalSunsetTime());
    }

}
