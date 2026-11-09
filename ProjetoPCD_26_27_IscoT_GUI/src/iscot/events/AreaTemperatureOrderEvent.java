package iscot.events;

import iscot.enums.AirConditioningMode;
import iscot.enums.Areas;

public class AreaTemperatureOrderEvent extends HighLevelOrderEvent {
    private static final long serialVersionUID = 1L;

    private final AirConditioningMode modo;

    public AreaTemperatureOrderEvent(Areas area, AirConditioningMode modo) {
        super(area);
        this.modo = modo;
    }

    public AirConditioningMode getModo() { return modo; }

    @Override
    public String toString() {
        return "AreaTemperatureOrderEvent[" + getArea() + ", modo=" + modo + "]";
    }
}