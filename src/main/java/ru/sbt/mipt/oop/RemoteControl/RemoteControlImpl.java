package ru.sbt.mipt.oop.RemoteControl;

import rc.RemoteControl;

import java.util.Map;

public class RemoteControlImpl implements RemoteControl {
    private final Map<String, RCCommand> commands;

    public RemoteControlImpl(Map<String, RCCommand> commands) {
        this.commands = commands;
    }

    public void setCommand(String buttonCode, RCCommand command) {
        commands.put(buttonCode, command);
    }

    @Override
    public void onButtonPressed(String buttonCode, String rcId) {
        RCCommand command = commands.get(buttonCode);
        if(command != null) {
            command.execute();
        }
    }
}
