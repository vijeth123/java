package com.vijeth.design.pattern.behavioral;

import java.util.ArrayList;
import java.util.List;

interface Subject{
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}

class Loan implements Subject{
    private List<Observer> observers;
    private int interest;

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
        notifyObservers();
    }

    public Loan(){
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.stream().forEach(observer -> {
            observer.update(interest);
        });
    }
}

interface Observer{
    public void update(int interest);
}

class NewsPaper implements Observer{
    @Override
    public void update(int interest) {
        System.out.println("Newspaper: The interest rate has been updated to: "+interest);
    }
}

class Internet implements Observer{
    @Override
    public void update(int interest) {
        System.out.println("Internet: The interest rate has been updated to: "+interest);
    }
}


public class ObserverPattern{
    public static void main(String[] args) {
        Loan loan = new Loan();
        loan.addObserver(new NewsPaper());
        loan.addObserver(new Internet());

        loan.setInterest(9);
        loan.setInterest(8);
        loan.setInterest(7);
    }
}