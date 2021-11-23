package ru.sbt.mipt.oop;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SmartHomeReaderFromJS implements SmartHomeReaderFromFile {
    private static final Logger logger = Logger.getLogger(SmartHomeReaderFromJS.class.getName());

    @Override
    public SmartHome readSmartHomeFromFile(String filePath) {
        Gson gson = new Gson();
        //SmartHome smartHome
        try {
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            return gson.fromJson(reader, SmartHome.class);
        }
        catch (IOException e) {
            logger.log(Level.SEVERE, () -> e.getMessage());
            return null;
        }
    }
}
