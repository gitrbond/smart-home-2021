package com.coolcompany.smarthome.sample;

import com.coolcompany.smarthome.events.SensorEventsManager;

public class Sample {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        SensorEventsManager sensorEventsManager = context.getBean(SensorEventsManager.class);
        sensorEventsManager.start();
    }
}
