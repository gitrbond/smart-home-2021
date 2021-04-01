package ru.sbt.mipt.oop;
import com.coolcompany.smarthome.events.CCSensorEvent;

public class CoolcompanyEventHandlerAdapter extends com.coolcompany.smarthome.events.EventHandler implements EventHandler {
    private com.coolcompany.smarthome.events.EventHandler coolcompanyEventHandler;

    CoolcompanyEventHandlerAdapter(com.coolcompany.smarthome.events.EventHandler coolcompanyEventHandler) {
        this.coolcompanyEventHandler = coolcompanyEventHandler;
    }

    @Override
    void handleEvent(SensorEvent event) {
        //coolcompanyEventHandler.handleEvent(coolcompanyEventHandler);
        System.out.println("Handling event");
    }
}
