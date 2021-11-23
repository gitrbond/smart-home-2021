package ru.sbt.mipt.oop;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SmartHomeRunner {
    private static final Logger logger = Logger.getLogger(SmartHomeRunner.class.getName());
    private final EventManager eventManager;
    private final SmartHomeEventSource eventSource;

    public SmartHomeRunner(EventManager eventManager, SmartHomeEventSource eventSource) {
        this.eventManager = eventManager;
        this.eventSource = eventSource;
    }

    public void runLoop() {
        SensorEvent event = eventSource.getNextSensorEvent();
        while (event != null) {
            logger.log(Level.INFO, "Got event: " + event);
            eventManager.manageEvent(event);
            event = eventSource.getNextSensorEvent();
        }
    }
}
