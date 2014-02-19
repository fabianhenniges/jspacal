package com.github.jspacal;

public interface SolarPosition {
    public EclipticCoordinates inEclipticCoordinates();

    public EquatorialCoordinates inEquatorialCoordinates();

    public HorizontalCoordiantes inHorizontalCoordiantes();
}
