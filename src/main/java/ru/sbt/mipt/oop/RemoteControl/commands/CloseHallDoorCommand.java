package ru.sbt.mipt.oop.RemoteControl.commands;

import ru.sbt.mipt.oop.RemoteControl.RCCommand;
import ru.sbt.mipt.oop.SmartHome.Door;
import ru.sbt.mipt.oop.SmartHome.Room;
import ru.sbt.mipt.oop.SmartHome.SmartHome;

public class CloseHallDoorCommand implements RCCommand {
    private final SmartHome smartHome;

    public CloseHallDoorCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute((object) -> {
            if (object instanceof Room) {
                Room room = (Room) object;
                if (room.getName().equals("hall")) {
                    room.execute(roomObj -> {
                        if (roomObj instanceof Door) {
                            Door door = (Door) roomObj;
                            door.setOpen(false);
                            System.out.println("Remotely closing hall door");
                        }
                    });
                }
            }
        });
    }
}
