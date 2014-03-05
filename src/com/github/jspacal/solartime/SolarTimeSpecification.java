/**
 @COPYRIGHT@
 */
package com.github.jspacal.solartime;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public interface SolarTimeSpecification {
    public SolarTimeIndication forDateTime(DateTime datetime);

    public SolarTimeIndication forLocalDate(LocalDate localdate);
}
