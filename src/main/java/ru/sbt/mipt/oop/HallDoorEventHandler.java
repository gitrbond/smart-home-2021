package ru.sbt.mipt.oop;

import java.util.logging.Level;
import java.util.logging.Logger;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class HallDoorEventHandler implements EventHandler {
    private static final Logger logger = Logger.getLogger(HallDoorEventHandler.class.getName());
    private final SmartHome smartHome;

    public HallDoorEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
        // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
        logger.log(Level.INFO, () ->"Turning lights off at whole home");
        if(event.getType().equals(DOOR_CLOSED) && findRoomByDoorId(event.getObjectId()).getName().equals("hall")) {
            for (Room room : smartHome.rooms) {
                for (Light light : room.getLights()) {
                    light.setOn(false);
                    SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                    CommandSender.sendCommand(command);
                }
            }
        }
    }

    private Room findRoomByDoorId(String doorId) {
        for (Room room : smartHome.rooms) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(doorId)) {
                    return room;
                }
            }
        }
        throw new DoorIdNotFoundException("Door with id=" + doorId + "is not found in home");
    }
}
