package com.vijeth.design.pattern;


abstract class OrderProcessTemplate{
    private boolean isGiftWrap;

    abstract public void select();
    abstract public void payment();
    abstract public void giftWrap();

    public final void processOrder(){
        select();
        payment();
        if(isGiftWrap){
            giftWrap();
        }
    }

    public void setGiftWrap(boolean isGiftWrap){
        this.isGiftWrap = isGiftWrap;
    }
}

class OnlineOrderProcess extends OrderProcessTemplate{
    @Override
    public void select() {
        System.out.println("Goto shopping.com and select items!");
    }
    @Override
    public void payment() {
        System.out.println("Netbanking..");
    }
    @Override
    public void giftWrap() {
        System.out.println("Color gift wrapping!!");
    }
}

class StoreOrderProcess extends OrderProcessTemplate{
    @Override
    public void select() {
        System.out.println("Goto near by shop!");
    }
    @Override
    public void payment() {
        System.out.println("Cash!");
    }
    @Override
    public void giftWrap() {
        System.out.println("Normal gift wrapping!!");
    }
}



public class TemplateMethodPattern{
    public static void main(String[] args) {
        System.out.println("$$$$$ Online order $$$$$$");
        OrderProcessTemplate onlineOrder = new OnlineOrderProcess();
        onlineOrder.setGiftWrap(true);
        onlineOrder.processOrder();

        System.out.println("\n\n$$$$$ Store order $$$$$$");
        OrderProcessTemplate storeOrder = new StoreOrderProcess();
        storeOrder.setGiftWrap(true);
        storeOrder.processOrder();
    }
}