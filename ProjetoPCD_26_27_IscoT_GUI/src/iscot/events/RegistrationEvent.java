package iscot.events;

import iscot.enums.Areas;
import iscot.enums.Type;

public class RegistrationEvent extends Event {
	private static final long serialVersionUID = 1L;

	private final Type type;
	private int id = -1;
	
	public RegistrationEvent(Type type, Areas area) {
		super(area);
		this.type=type;
	}
	
	public Type getType() { return type; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    @Override
    public String toString() {
        return "RegistrationEvent[" + type + ", " + getArea() + ", id=" + id + "]";
    }
}
