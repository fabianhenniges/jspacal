/**
 @COPYRIGHT@
 */
package com.github.jspacal.position.earth;

import org.joda.time.DateTime;

public interface EarthPositionSpecification {
    public EarthPosition forDateTime(DateTime datetime);
}
