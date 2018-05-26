package com.vijeth.design.pattern.behavioral;

interface Command{
    public void execute();
}

class Light{
    private boolean isOn = false;

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}

class LightOnCommand implements Command{
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.setOn(true);
        System.out.println("Light turned on!");
    }
}


class LightOffCommand implements Command{
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.setOn(false);
        System.out.println("Light turned off!");
    }
}

class RemoteControl{
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void buttonPress(){
        command.execute();
    }
}

public class CommandPattern {

    public static void main(String[] args) {
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(lightOnCommand);
        remoteControl.buttonPress();

        remoteControl.setCommand(lightOffCommand);
        remoteControl.buttonPress();
    }
}
