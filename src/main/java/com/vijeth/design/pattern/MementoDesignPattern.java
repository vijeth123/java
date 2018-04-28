package com.vijeth.design.pattern;

import java.util.*;

class Memento{
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Originator{

      private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

class CareTaker{
   private List<Memento> mementos = new ArrayList<>();
   private int counter = -1;

    public void addState(String state){
        counter++;
        mementos.add(counter, new Memento(state));
    }

    public String getPreviousState(){
        if(counter > 0){
            counter--;
            return mementos.get(counter).getState();
        }
        return mementos.get(0).getState();
    }

    public String getNextState(){
        if(counter < mementos.size() - 1){
            counter++;
            return mementos.get(counter).getState();
        }
        return mementos.get(mementos.size() - 1).getState();
    }
}

public class MementoDesignPattern {

    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setState("Awesome");
        System.out.println("Added "+originator.getState());
        careTaker.addState(originator.getState());

        originator.setState("Super");
        System.out.println("Added "+originator.getState());
        careTaker.addState(originator.getState());

        originator.setState("Nice");
        System.out.println("Added "+originator.getState());
        careTaker.addState(originator.getState());

        originator.setState("Good");
        System.out.println("Added "+originator.getState());
        careTaker.addState(originator.getState());

        originator.setState("Brilliant");
        System.out.println("Added "+originator.getState());
        careTaker.addState(originator.getState());

        System.out.println("\n\nOriginator's current state: "+originator.getState());

        System.out.println("\nOriginator going back to previous state");
        originator.setState(careTaker.getPreviousState());
        System.out.println("Originator's current state: "+originator.getState());

        System.out.println("\nOriginator going back to previous state");
        originator.setState(careTaker.getPreviousState());
        System.out.println("Originator's current state: "+originator.getState());

        System.out.println("\nOriginator Re-do action!");
        originator.setState(careTaker.getNextState());
        System.out.println("Originator's current state: "+originator.getState());

        System.out.println("\nOriginator Re-do action!");
        originator.setState(careTaker.getNextState());
        System.out.println("Originator's current state: "+originator.getState());


        System.out.println("\nOriginator going back to previous state");
        originator.setState(careTaker.getPreviousState());
        System.out.println("Originator's current state: "+originator.getState());

        System.out.println("\nOriginator going back to previous state");
        originator.setState(careTaker.getPreviousState());
        System.out.println("Originator's current state: "+originator.getState());

        System.out.println("\nOriginator going back to previous state");
        originator.setState(careTaker.getPreviousState());
        System.out.println("Originator's current state: "+originator.getState());

        System.out.println("\nOriginator going back to previous state");
        originator.setState(careTaker.getPreviousState());
        System.out.println("Originator's current state: "+originator.getState());

        System.out.println("\nOriginator going back to previous state");
        originator.setState(careTaker.getPreviousState());
        System.out.println("Originator's current state: "+originator.getState());

        System.out.println("\nOriginator going back to previous state");
        originator.setState(careTaker.getPreviousState());
        System.out.println("Originator's current state: "+originator.getState());

        System.out.println("\nOriginator Re-do action!");
        originator.setState(careTaker.getNextState());
        System.out.println("Originator's current state: "+originator.getState());

        System.out.println("\nOriginator Re-do action!");
        originator.setState(careTaker.getNextState());
        System.out.println("Originator's current state: "+originator.getState());


    }

}
