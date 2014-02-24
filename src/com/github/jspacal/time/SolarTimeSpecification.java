/**
 @COPYRIGHT@
 */
package com.github.jspacal.time;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public interface SolarTimeSpecification {
    public SolarTimeIndication forDateTime(DateTime datetime);

    public SolarTimeIndication forLocalDate(LocalDate localdate);
}
