package ru.sbt.mipt.oop;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandSender {
    private static final Logger logger = Logger.getLogger(CommandSender.class.getName());

    public CommandSender() {
    }

    public static void sendCommand(SensorCommand command) {
        //System.out.println("Pretend we're sending command " + command);
        logger.log(Level.INFO, "Pretend we're sending command " + command);
    }
}
