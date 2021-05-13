package ru.sbt.mipt.oop.RemoteControl.commands;

import ru.sbt.mipt.oop.RemoteControl.RCCommand;
import ru.sbt.mipt.oop.alarm.Alarm;

public class AlarmAlertCommand implements RCCommand {
    private final Alarm alarm;

    public AlarmAlertCommand(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void execute() {
        alarm.alert();
    }
}
