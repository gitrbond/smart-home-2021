package ru.sbt.mipt.oop.RemoteControl.commands;

import ru.sbt.mipt.oop.RemoteControl.RCCommand;
import ru.sbt.mipt.oop.alarm.Alarm;

public class AlarmActivateCommand implements RCCommand {
    private final Alarm alarm;
    private final String code = "0000";

    public AlarmActivateCommand(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void execute() {
        alarm.activate(code);
    }
}
