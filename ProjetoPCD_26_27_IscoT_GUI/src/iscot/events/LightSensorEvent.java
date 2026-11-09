package iscot.events;

import iscot.enums.Areas;

public class LightSensorEvent extends SensorEvent {
    private static final long serialVersionUID = 1L;

    public LightSensorEvent(Areas area, double valor) {
        super(area, valor);
    }
}