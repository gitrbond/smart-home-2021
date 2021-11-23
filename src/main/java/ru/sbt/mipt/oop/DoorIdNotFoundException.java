package ru.sbt.mipt.oop;

public class DoorIdNotFoundException extends RuntimeException {
    public DoorIdNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
