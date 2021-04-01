package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.alarm.Alarm;

import static ru.sbt.mipt.oop.SensorEventType.ALARM_ACTIVATE;

public class AlarmEventHandlerDecorator implements EventHandler {
    private EventHandler wrappee;
    private Alarm alarm;
    //убрвть смартхоум
    //передать аларм как параметр в конструкторе
    AlarmEventHandlerDecorator(Alarm alarm, EventHandler eventHandler) {
        wrappee = eventHandler;
        this.alarm = alarm;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        if ((alarm.isActivated() || alarm.isAlert()) && event.getType() != SensorEventType.ALARM_DEACTIVATE) {
            alarm.alert();
            System.out.println("Sending SMS...");
        }
        else
            wrappee.handleEvent(event);
    }
}
