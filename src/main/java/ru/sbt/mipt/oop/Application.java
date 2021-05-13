package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rc.RemoteControl;
import rc.RemoteControlRegistry;


public class Application {

    public static void main(String... args) {
        AbstractApplicationContext configuration = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        SensorEventsManager sensorEventsManager = configuration.getBean(SensorEventsManager.class);
        RemoteControlRegistry remoteControlRegistry = configuration.getBean(RemoteControlRegistry.class);
        sensorEventsManager.start();
    }
}
