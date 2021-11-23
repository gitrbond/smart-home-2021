package ru.sbt.mipt.oop;

import java.util.logging.Level;
import java.util.logging.Logger;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventHandler implements EventHandler{
    private static final Logger logger = Logger.getLogger(DoorEventHandler.class.getName());
    private final SmartHome smartHome;

    public DoorEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        // событие от двери
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType() == DOOR_OPEN) {
                        door.setOpen(true);
                        //System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
                        logger.log(Level.INFO,"Door " + door.getId() + " in room " + room.getName() + " was opened.");
                    }
                    if (event.getType() == DOOR_CLOSED) {
                        door.setOpen(false);
                        //System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
                        logger.log(Level.INFO,"Door " + door.getId() + " in room " + room.getName() + " was closed.");
                    }
                }
            }
        }
    }
}
