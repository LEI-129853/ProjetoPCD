package iscot.events;

import iscot.enums.AirConditioningMode;
import iscot.enums.Areas;
import iscot.enums.Type;

public class TesteEventos {
    public static void main(String[] args) {
        Event r  = new RegistrationEvent(Type.SENSOR, Areas.Kitchen);
        Event s  = new LightSensorEvent(Areas.Kitchen, 120);
        Event o1 = new AreaLightingOrderEvent(Areas.Kitchen, true);
        Event o2 = new AreaTemperatureOrderEvent(Areas.BedRoom, AirConditioningMode.Frio);

        System.out.println(r);
        System.out.println(s);
        System.out.println(o1);
        System.out.println(o2);

        System.out.println(s instanceof SensorEvent);          // true
        System.out.println(o1 instanceof HighLevelOrderEvent); // true
        System.out.println(s instanceof HighLevelOrderEvent);  // false
    }
}