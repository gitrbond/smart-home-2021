package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.EventHandler.*;
import ru.sbt.mipt.oop.SmartHome.SmartHome;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.alarm.AlertAlarmNotifier;
import ru.sbt.mipt.oop.alarm.AlertAlarmSMSNotifier;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public SmartHome createSmartHome() {
        return new SmartHomeReaderFromJS().readSmartHomeFromFile("smart-home-1.js");
    }

    @Bean
    public Alarm createAlarm() {
        return new Alarm("666");
    }

    @Bean
    public AlertAlarmNotifier createAlertAlarmNotifier() {
        return new AlertAlarmSMSNotifier();
    }

    @Bean
    public EventHandler createLightEventHandler() {
        return new AlarmEventHandlerDecorator(createAlarm(), new LightEventHandler(createSmartHome()), createAlertAlarmNotifier());
    }

    @Bean
    public EventHandler createDoorEventHandler() {
        return new AlarmEventHandlerDecorator(createAlarm(), new DoorEventHandler(createSmartHome()), createAlertAlarmNotifier());
    }

    @Bean
    public EventHandler createHallDoorEventHandler() {
        return new AlarmEventHandlerDecorator(createAlarm(), new HallDoorEventHandler(createSmartHome()), createAlertAlarmNotifier());
    }

    @Bean
    public SensorEventsManager createSensorEventManager(Collection<EventHandler> eventHandlers) {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();

        Map<String, SensorEventType> map = new HashMap<>();
        map.put("LightIsOn", SensorEventType.LIGHT_ON);
        map.put("LightIsOff", SensorEventType.LIGHT_OFF);
        map.put("DoorIsOpen", SensorEventType.DOOR_OPEN);
        map.put("DoorIsClosed", SensorEventType.DOOR_CLOSED);
        map.put("DoorIsLocked", SensorEventType.DOOR_LOCKED);
        map.put("DoorIsUnlocked", SensorEventType.DOOR_UNLOCKED);

        for (EventHandler handler : eventHandlers) {
            sensorEventsManager.registerEventHandler(new CCEventHandlerAdapter(handler, map));
        }
        return sensorEventsManager;
    }
}
