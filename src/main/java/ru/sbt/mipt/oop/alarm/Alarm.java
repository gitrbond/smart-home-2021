package ru.sbt.mipt.oop.alarm;

public class Alarm {
    private AlarmState state = new DeactivatedAlarmState(this);
    private String code;

    void setState(AlarmState state) {
        this.state = state;
    }

    void setCode(String newCode) {
        if (state instanceof  DeactivatedAlarmState)
            code = newCode;
    }

    boolean correctCode(String otherCode) {
        return code.equals(otherCode);
    }
    public void activate(String code) {
        state.activate(code);
    }

    public void deactivate(String code) {
        state.deactivate(code);
    }

    public void alert() {
        state.alert();
    }

}
