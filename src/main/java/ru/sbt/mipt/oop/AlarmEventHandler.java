package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.ALARM_ACTIVATE;

public class AlarmEventHandler implements EventHandler {
    @Override
    public void handleEvent(SmartHome smartHome, SensorEvent event) {
        if (event.getType() == ALARM_ACTIVATE) {
            smartHome.alarm.activate(event.getObjectId());
        }
        else
            smartHome.alarm.deactivate(event.getObjectId());
    }
}
