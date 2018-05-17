package com.vijeth.design.pattern.structural;

class Volt{
    private int volts;

    public Volt(int volts){
        this.volts = volts;
    }

    public int getVolts(){
        return volts;
    }

    @Override
    public String toString() {
        return "Volt{" +
                "volts=" + volts +
                '}';
    }
}

class WallSocket{
    public Volt getWallSocketVolts(){
        return new Volt(120);
    }
}

interface Adapter{
    public Volt get120Volts();
    public Volt get12Volts();
    public Volt get3Volts();
}

class MobileCharger implements Adapter{
    private WallSocket wallSocket;

    public MobileCharger(WallSocket wallSocket){
        this.wallSocket = wallSocket;
    }

    @Override
    public Volt get120Volts() {
        return wallSocket.getWallSocketVolts();
    }

    @Override
    public Volt get12Volts() {
        return new Volt(convertVoltage(wallSocket, 10));
    }

    @Override
    public Volt get3Volts() {
        return new Volt(convertVoltage(wallSocket, 40));
    }

    private int convertVoltage(WallSocket wallSocket, int times){
        Volt wallChargerVoltage = wallSocket.getWallSocketVolts();
        return wallChargerVoltage.getVolts()/times;
    }
}

interface MobilePhone{
    public Volt get3Volts();
}

class LenovoP2 implements MobilePhone{
    private Adapter adapter;

    public LenovoP2(Adapter adapter){
        this.adapter = adapter;
    }

    @Override
    public Volt get3Volts() {
        return adapter.get3Volts();
    }
}


public class AdapterTest {
    public static void main(String[] args) {
        WallSocket wallSocket = new WallSocket();
        Adapter adapter = new MobileCharger(wallSocket);
        MobilePhone mobilePhone = new LenovoP2(adapter);
        System.out.println(mobilePhone.get3Volts());
    }
}
