package ru.sbt.mipt.oop.alarm;

public class Alarm {
    private AlarmState state;
    private String code;

    public Alarm(String code) {
        this.code = code;
        state = new DeactivatedAlarmState(this);
    }

    void setState(AlarmState state) {
        this.state = state;
    }

    void setCode(String newCode) {
        if (state instanceof  DeactivatedAlarmState)
            code = newCode;
    }

    public boolean correctCode(String otherCode) {
        return code.equals(otherCode);
    }

    public void activate(String code) {
        state.activate(code);
    }

    public boolean isActivated() {
        return state instanceof ActivatedAlarmState;
    }

    public void deactivate(String code) {
        state.deactivate(code);
    }

    public boolean isDeactivated() {
        return state instanceof DeactivatedAlarmState;
    }

    public void alert() {
        state.alert();
    }

    public boolean isAlert() {
        return state instanceof AlertAlarmState;
    }
}
