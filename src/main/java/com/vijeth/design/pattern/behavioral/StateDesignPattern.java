package com.vijeth.design.pattern.behavioral;


interface AlertType{
    public void alert();
}

class Silent implements AlertType{
    @Override
    public void alert() {
        System.out.println("Silent........!!");
    }
}

class Vibrate implements AlertType{
    @Override
    public void alert() {
        System.out.println("Vibrating.......!!");
    }
}

class Mobile{
    private String name;

    private AlertType alertType;

    public Mobile(String name){
        this.name = name;
        this.alertType = new Vibrate();
    }

    public void setAlertType(AlertType alertType) {
        this.alertType = alertType;
    }

    public void doAlert(){
        alertType.alert();
    }
}


public class StateDesignPattern {

    public static void main(String[] args) {
        Mobile mobile = new Mobile("Nokia 1100");
        mobile.doAlert();
        mobile.setAlertType(new Silent());
        mobile.doAlert();
        mobile.doAlert();
        mobile.setAlertType(new Vibrate());
        mobile.doAlert();
    }
}
