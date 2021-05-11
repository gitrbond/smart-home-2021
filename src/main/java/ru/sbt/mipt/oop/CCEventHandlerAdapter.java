package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.EventHandler.EventHandler;

import java.util.Map;

public class CCEventHandlerAdapter implements com.coolcompany.smarthome.events.EventHandler {
    private final EventHandler eventHandler;
    private final Map<String, SensorEventType> tableOfEventCompliance;

    CCEventHandlerAdapter(EventHandler eventHandler, Map<String, SensorEventType> tableOfEventCompliance) {
        this.eventHandler = eventHandler;
        this.tableOfEventCompliance = tableOfEventCompliance;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        eventHandler.handleEvent(new SensorEvent(tableOfEventCompliance.get(event.getEventType()), event.getObjectId()));
        System.out.println("Handling event");
    }
}
