package com.vijeth.design.pattern.structural;

class Inventory{
    public void checkInventory(String orderId){
        System.out.println("Inventory checked for the order# "+orderId);
    }
}

class Payment{
    public void paymentDeducted(String orderId){
        System.out.println("Payment deducted for the order# "+orderId);
    }
}

class OrderFacade{
    private Inventory inventory = new Inventory();
    private Payment payment = new Payment();

    public void order(String orderId){
        inventory.checkInventory(orderId);
        payment.paymentDeducted(orderId);
    }
}


public class FacadePattern {
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();
        orderFacade.order("34023487");
    }
}
