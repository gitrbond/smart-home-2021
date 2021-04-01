package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.alarm.Alarm;

import static ru.sbt.mipt.oop.SensorEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.SensorEventType.ALARM_DEACTIVATE;

public class AlarmEventHandler implements EventHandler {
    Alarm alarm;
    //убрвть смартхоум
    //передать аларм как параметр в конструкторе
    AlarmEventHandler(Alarm alarm) {
        this.alarm = alarm;
    }
    @Override
    public void handleEvent(SensorEvent event) {
        if (event.getType() == ALARM_ACTIVATE) {
            alarm.activate(event.getObjectId());
        }
        if (event.getType() == ALARM_DEACTIVATE) {
            alarm.deactivate(event.getObjectId());
        }
    }
}
