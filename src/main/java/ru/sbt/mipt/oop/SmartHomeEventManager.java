package ru.sbt.mipt.oop;

import java.util.List;

public class SmartHomeEventManager implements EventManager {
    private final List<EventHandler> eventHandlers;

    public SmartHomeEventManager(List<EventHandler> eventHandlers) {
        this.eventHandlers = eventHandlers;
    }

    @Override
    public void manageEvent(SensorEvent event) {
        eventHandlers.forEach(eventHandler -> eventHandler.handleEvent(event));
    }
}
