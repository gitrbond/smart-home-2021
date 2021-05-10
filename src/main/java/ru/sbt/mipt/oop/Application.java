package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventHandler.DoorEventHandler;
import ru.sbt.mipt.oop.EventHandler.HallDoorEventHandler;
import ru.sbt.mipt.oop.EventHandler.LightEventHandler;
import ru.sbt.mipt.oop.SmartHome.SmartHome;

import java.util.Arrays;

public class Application {

    public static void main(String... args) {
        // считываем состояние дома из файла
        SmartHome smartHome = new SmartHomeReaderFromJS().readSmartHomeFromFile("smart-home-1.js");
        EventManager eventManager = new SmartHomeEventManager(Arrays.asList(new LightEventHandler(smartHome), new DoorEventHandler(smartHome), new HallDoorEventHandler(smartHome)));
        SmartHomeRunner smartHomeRunner = new SmartHomeRunner(eventManager, new SmartHomeEventSource());
        // начинаем цикл обработки событий
        smartHomeRunner.runLoop();
    }
}
