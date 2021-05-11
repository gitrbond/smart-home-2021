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
        if (alarm.isDeactivated()) {
            wrappee.handleEvent(event);
        }
        else if (event.getType() == SensorEventType.ALARM_DEACTIVATE || event.getType() == SensorEventType.ALARM_ACTIVATE) {
            if (alarm.correctCode(event.getType().code)) {
                wrappee.handleEvent(event);
            }
            else {
                alarm.alert();
                alertAlarmNotifier.sendNotification();
            }
        }
        else {
            alarm.alert();
            alertAlarmNotifier.sendNotification();
        }
    }
}
