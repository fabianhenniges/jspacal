/**
 @COPYRIGHT@
 */
package com.github.jspacal.position.solar;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public interface SolarPositionSpecification {
    public SolarPosition forDateTime(DateTime datetime);

    public SolarPosition atSunrise(LocalDate localdate);

    public SolarPosition atSunset(LocalDate localdate);
}
