package ru.sbt.mipt.oop;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandSender {
    private static final Logger logger = Logger.getLogger(CommandSender.class.getName());

    private CommandSender() {}

    public static void sendCommand(SensorCommand command) {
        logger.log(Level.INFO, () ->"Pretend we're sending command " + command);
    }
}
