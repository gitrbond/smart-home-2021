package ru.sbt.mipt.oop.alarm;

public class AlertAlarmState implements AlarmState {
    protected Alarm alarm;

    public AlertAlarmState(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void activate(String code) {
        //already activated
    }

    @Override
    public void deactivate(String code) {
        if (alarm.correctCode(code)) {
            alarm.setState(new ActivatedAlarmState(alarm));
        }
    }

    @Override
    public void alert() {
        //nothing to do
    }
}
