package ru.sbt.mipt.oop;

import java.util.Random;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class SmartHomeEventSource {
    final Random random = new Random();

    public SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[random.nextInt(4)];
        String objectId = "" + (1 + random.nextInt(10));
        if(sensorEventType.equals(DOOR_OPEN) || sensorEventType.equals(DOOR_CLOSED)) {
            objectId = "" + (1 + random.nextInt(4));
        }
        return new SensorEvent(sensorEventType, objectId);
    }
}
