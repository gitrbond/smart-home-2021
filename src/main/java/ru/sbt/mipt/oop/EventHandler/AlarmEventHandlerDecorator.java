package ru.sbt.mipt.oop.EventHandler;

import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.alarm.AlertAlarmNotifier;

public class AlarmEventHandlerDecorator implements EventHandler {
    private final EventHandler wrappee;
    private final Alarm alarm;
    private final AlertAlarmNotifier alertAlarmNotifier;

    public AlarmEventHandlerDecorator(Alarm alarm, EventHandler eventHandler, AlertAlarmNotifier alertAlarmNotifier) {
        wrappee = eventHandler;
        this.alarm = alarm;
        this.alertAlarmNotifier = alertAlarmNotifier;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        if ((alarm.isActivated() || alarm.isAlert()) && (event.getType() != SensorEventType.ALARM_DEACTIVATE && event.getType() != SensorEventType.ALARM_ACTIVATE)) {
            alarm.alert();
            alertAlarmNotifier.sendNotification();
        }
        else
            wrappee.handleEvent(event);
    }
}
