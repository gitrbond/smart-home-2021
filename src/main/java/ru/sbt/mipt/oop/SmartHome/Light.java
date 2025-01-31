package ru.sbt.mipt.oop.SmartHome;

public class Light implements Actionable {
    private boolean isOn;
    private final String id;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public void execute(Action action) {
        //System.out.println("light id=" + id + " executing");
        action.act(this);
    }

    /*@Override
    public void act(ActionStrategy action) {
        if (action.getObjectId().equals(id)) {
            System.out.println("Alo!");
        }
    }*/
}
