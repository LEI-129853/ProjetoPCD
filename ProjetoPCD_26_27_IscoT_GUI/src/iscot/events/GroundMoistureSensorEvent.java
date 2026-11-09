package iscot.events;

import iscot.enums.Areas;

public class GroundMoistureSensorEvent extends SensorEvent {
    private static final long serialVersionUID = 1L;

    public GroundMoistureSensorEvent(Areas area, double valor) {
        super(area, valor);
    }
}