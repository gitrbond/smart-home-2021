package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventHandler.*;
import ru.sbt.mipt.oop.SmartHome.SmartHome;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.alarm.AlertAlarmNotifier;
import ru.sbt.mipt.oop.alarm.AlertAlarmSMSNotifier;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String... args) {
        // считываем состояние дома из файла
        SmartHome smartHome = new SmartHomeReaderFromJS().readSmartHomeFromFile("smart-home-1.js");
        Alarm alarm = new Alarm("666");
        AlertAlarmNotifier notifier = new AlertAlarmSMSNotifier();
        // список Handler-ов
        List<EventHandler> eventHandlers = new ArrayList<>();
        eventHandlers.add(new AlarmEventHandler(alarm));
        // обертки
        eventHandlers.add(new AlarmEventHandlerDecorator(alarm, new DoorEventHandler(smartHome), notifier));
        eventHandlers.add(new AlarmEventHandlerDecorator(alarm, new HallDoorEventHandler(smartHome), notifier));
        eventHandlers.add(new AlarmEventHandlerDecorator(alarm, new LightEventHandler(smartHome), notifier));

        EventManager eventManager = new SmartHomeEventManager(eventHandlers);//Arrays.asList(new LightEventHandler(smartHome), new DoorEventHandler(smartHome), new HallDoorEventHandler(smartHome)));
        SmartHomeRunner smartHomeRunner = new SmartHomeRunner(eventManager, new SmartHomeEventSource());
        // начинаем цикл обработки событий
        smartHomeRunner.runLoop();
    }
}
