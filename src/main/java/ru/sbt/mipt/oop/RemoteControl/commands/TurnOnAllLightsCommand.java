package ru.sbt.mipt.oop.RemoteControl.commands;

import ru.sbt.mipt.oop.RemoteControl.RCCommand;
import ru.sbt.mipt.oop.SmartHome.Light;
import ru.sbt.mipt.oop.SmartHome.SmartHome;

public class TurnOnAllLightsCommand implements RCCommand {
    private final SmartHome smartHome;

    public TurnOnAllLightsCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute((object) -> {
            if(object instanceof Light) {
                Light light = (Light) object;
                light.setOn(true);
                System.out.println("Remotely turning light on");
            }
        });
    }
}
