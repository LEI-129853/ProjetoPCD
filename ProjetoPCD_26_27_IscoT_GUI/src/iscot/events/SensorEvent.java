package iscot.events;

import iscot.enums.Areas;

public abstract class SensorEvent extends Event {
    private static final long serialVersionUID = 1L;

    private final double valor;

    public SensorEvent(Areas area, double valor) {
        super(area);
        this.valor = valor;
    }

    public double getValor() { return valor; }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" + getArea() + ", valor=" + valor + "]";
    }
}