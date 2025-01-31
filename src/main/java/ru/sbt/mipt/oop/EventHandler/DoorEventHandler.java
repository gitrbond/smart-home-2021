package ru.sbt.mipt.oop.EventHandler;

import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome.Door;
import ru.sbt.mipt.oop.SmartHome.SmartHome;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class DoorEventHandler implements EventHandler{
    private final SmartHome smartHome;

    public DoorEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        // событие от двери
        //System.out.println("Handling door event");
        smartHome.execute((object) -> {
            if(object instanceof Door) {
                //System.out.println("A");
                Door door = (Door) object;
                if(door.getId().equals(event.getObjectId())) {
                    if(event.getType().equals(DOOR_OPEN)) {
                        door.setOpen(true);
                        System.out.println("door " + door.getId() + " was set OPEN");
                    }
                    if(event.getType().equals(DOOR_CLOSED)) {
                        door.setOpen(false);
                        System.out.println("door " + door.getId() + " was set CLOSED");
                    }
                }
            }
        });
    }
}
