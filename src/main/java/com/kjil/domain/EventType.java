package com.kjil.domain;

public enum EventType {
    DASH_100_M(Unit.SECONDS, 25.4347, 18.0, 1.81),
    LONG_JUMP(Unit.METRES, 0.14354, 220.0, 1.4),
    SHOT_PUT(Unit.METRES, 51.39, 1.5, 1.05),
    HIGH_JUMP(Unit.METRES, 0.8465, 75.0, 1.42),
    DASH_400_M(Unit.SECONDS, 1.53775, 82.0, 1.81),
    HURDLES_110_M(Unit.SECONDS, 5.74352, 28.5, 1.92),
    DISCUS_THROW(Unit.METRES, 12.91, 4.0, 1.1),
    POLE_VAULT(Unit.METRES, 0.2797, 100.0, 1.35),
    JAVELIN_THROW(Unit.METRES, 10.14, 7.0, 1.08),
    RUN_1500_M(Unit.SECONDS, 0.03768, 480.0, 1.85);

    private Unit unit;
    private Double a;
    private Double b;
    private Double c;

    EventType(Unit unit, Double a, Double b, Double c) {
        this.unit = unit;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Double getA() {
        return a;
    }

    public Double getB() {
        return b;
    }

    public Double getC() {
        return c;
    }

    public Unit getUnit() {
        return unit;
    }
}
