package iscot.events;

import iscot.enums.Areas;

public class AreaVentilationOrderEvent extends HighLevelOrderEvent {
    private static final long serialVersionUID = 1L;

    private final boolean ligar;

    public AreaVentilationOrderEvent(Areas area, boolean ligar) {
        super(area);
        this.ligar = ligar;
    }

    public boolean isLigar() { return ligar; }

    @Override
    public String toString() {
        return "AreaVentilationOrderEvent[" + getArea() + ", ligar=" + ligar + "]";
    }
}