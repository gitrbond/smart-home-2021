package ru.sbt.mipt.oop.alarm;

public class ActivatedAlarmState implements AlarmState {
    protected Alarm alarm;

    public ActivatedAlarmState(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void activate(String code) {
        //already activated
    }

    @Override
    public void deactivate(String code) {
        if (alarm.correctCode(code)) {
            alarm.setState(new DeactivatedAlarmState(alarm));
        }
        else {
            alarm.setState(new AlertAlarmState(alarm));
        }
    }

    @Override
    public void alert() {
        alarm.setState(new AlertAlarmState(alarm));
    }
}
