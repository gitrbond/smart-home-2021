package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.CCSensorEvent;

public class CCEventHandlerAdapter implements com.coolcompany.smarthome.events.EventHandler {
    private com.coolcompany.smarthome.events.EventHandler cCEventHandler;

    CCEventHandlerAdapter(com.coolcompany.smarthome.events.EventHandler coolcompanyEventHandler) {
        this.cCEventHandler = coolcompanyEventHandler;
    }

    @Override
    void handleEvent(CCSensorEvent event) {
        //coolcompanyEventHandler.handleEvent(coolcompanyEventHandler);
        System.out.println("Handling event");
    }
}
