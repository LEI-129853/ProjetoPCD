package iscot.events;

import java.io.Serializable;
import iscot.enums.Areas;

public abstract class Event implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private final Areas area;
	private final Long timestamp;
	
	public Event(Areas area) {
		this.area=area;
		this.timestamp=System.currentTimeMillis();
	}
	public Areas getArea() { return area; }
    public long getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" + area + "]";
    }
}
