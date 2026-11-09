package iscot.events;

import iscot.enums.Areas;

public abstract class HighLevelOrderEvent extends Event {
    private static final long serialVersionUID = 1L;

    public HighLevelOrderEvent(Areas area) {
        super(area);
    }
}