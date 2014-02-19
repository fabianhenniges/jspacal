package com.github.jspacal;

import org.joda.time.DateTime;

public interface TimeSpec {
    public double asFractionalHourOfDay();

    public DateTime asDateTime();
}
