package com.vijeth.design.pattern;

interface Chain{
    public void setNext(Chain chain);
    public void process(int n);
}

class ZeroProcessor implements Chain{

    private Chain nextInChain;

    @Override
    public void setNext(Chain chain) {
        this.nextInChain = chain;
    }

    @Override
    public void process(int n) {
        if(n == 0){
            System.out.println("Zero process in action!!");
        }else{
            nextInChain.process(n);
        }
    }
}
class NegativeProcessor implements Chain{

    private Chain nextInChain;

    @Override
    public void setNext(Chain chain) {
        this.nextInChain = chain;
    }

    @Override
    public void process(int n) {
        if(n < 0){
            System.out.println("NegativeProcessor in action!!");
        }else {
            nextInChain.process(n);
        }
    }
}

class PositiveProcessor implements Chain{

    private Chain nextInChain;

    @Override
    public void setNext(Chain chain) {
        this.nextInChain = chain;
    }

    @Override
    public void process(int n) {
        if(n > 0){
            System.out.println("Positive processor in action!!");
        }else{
            nextInChain.process(n);
        }
    }
}

public class ChainOfResponsibility {
    public static void main(String[] args) {
        Chain pc = new PositiveProcessor();
        Chain nc = new NegativeProcessor();
        Chain zc = new ZeroProcessor();
        pc.setNext(nc);
        nc.setNext(zc);

        pc.process(0);
        pc.process(-1);
        pc.process(2);

        nc.process(0);
    }
}
