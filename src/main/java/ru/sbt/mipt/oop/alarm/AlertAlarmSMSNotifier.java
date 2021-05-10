package ru.sbt.mipt.oop.alarm;

public class AlertAlarmSMSNotifier implements AlertAlarmNotifier {
    @Override
    public void sendNotification() {
        System.out.println("Sending sms");
    }
}
