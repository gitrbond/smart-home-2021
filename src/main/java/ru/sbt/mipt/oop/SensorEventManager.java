package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;
//import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

public class SensorEventManager {
    LightEventHandler lightEventHandler;
    DoorEventHandler doorEventHandler;
    AlarmEventHandlerDecorator alarmEventHandlerDecorator;
    SmartHome smartHome;

    public SensorEventManager(SmartHome smartHome) {
        lightEventHandler = new LightEventHandler(smartHome);
        doorEventHandler = new DoorEventHandler(smartHome);
        alarmEventHandlerDecorator = new AlarmEventHandlerDecorator(smartHome.alarm, new AlarmEventHandler(smartHome.alarm));
        this.smartHome = smartHome;
    }

    public void SensorEventManagerLoop() {
        SensorEvent event = getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            if (smartHome.alarm.isDeactivated()) {
                if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {
                    lightEventHandler.handleEvent(event);
                }
                if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
                    doorEventHandler.handleEvent(event);
                }
            }
            alarmEventHandlerDecorator.handleEvent(event);
            event = getNextSensorEvent();
        }
    }

    private static SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (6 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}
