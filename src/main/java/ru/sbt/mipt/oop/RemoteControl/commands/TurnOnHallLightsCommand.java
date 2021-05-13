package ru.sbt.mipt.oop.RemoteControl.commands;

import ru.sbt.mipt.oop.RemoteControl.RCCommand;
import ru.sbt.mipt.oop.SmartHome.Light;
import ru.sbt.mipt.oop.SmartHome.Room;
import ru.sbt.mipt.oop.SmartHome.SmartHome;

public class TurnOnHallLightsCommand implements RCCommand {
    private SmartHome smartHome;

    public TurnOnHallLightsCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(object -> {
            if (object instanceof Room) {
                Room room = (Room) object;
                if (room.getName().equals("hall")) {
                    room.execute(roomObj -> {
                        if (roomObj instanceof Light) {
                            Light light = (Light) roomObj;
                            light.setOn(true);
                        }
                    });
                    System.out.println("Remotely turning on hall lights");
                }
            }
        });
    }
}
