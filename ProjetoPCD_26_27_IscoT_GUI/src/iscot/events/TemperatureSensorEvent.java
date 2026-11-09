package iscot.events;

import iscot.enums.Areas;

public class TemperatureSensorEvent extends SensorEvent {
    private static final long serialVersionUID = 1L;

    public TemperatureSensorEvent(Areas area, double valor) {
        super(area, valor);
    }
}