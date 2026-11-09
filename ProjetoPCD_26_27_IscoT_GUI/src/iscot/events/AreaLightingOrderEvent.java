package iscot.events;

import iscot.enums.Areas;

public class AreaLightingOrderEvent extends HighLevelOrderEvent {
    private static final long serialVersionUID = 1L;

    private final boolean ligar;

    public AreaLightingOrderEvent(Areas area, boolean ligar) {
        super(area);
        this.ligar = ligar;
    }

    public boolean isLigar() { return ligar; }

    @Override
    public String toString() {
        return "AreaLightingOrderEvent[" + getArea() + ", ligar=" + ligar + "]";
    }
}
