package com.vijeth.design.pattern;

import java.util.ArrayList;
import java.util.List;

interface User{
    public void send(String message);
    public void receive(String message);
}

interface ChatMediator{
    public void addUser(User user);
    public void send(String message, User user);
}

class ChatUser implements User{

    private String name;
    private ChatMediator chatMediator;

    public ChatUser(String name, ChatMediator chatMediator){
        this.name = name;
        this.chatMediator = chatMediator;
    }

    public String getName(){
        return  name;
    }

    @Override
    public void send(String message) {
        System.out.println(this.getName()+" sent a message: "+ message);
        chatMediator.send(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(this.getName()+" received the message: "+ message);
    }
}

class ChatMediatorImpl implements ChatMediator{

    List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void send(String message, User user) {
        users.stream().filter(u -> !u.equals(user)).forEach(u -> u.receive(message));
    }
}


public class MediatorDesignPattern {

    public static void main(String[] args) {
        ChatMediator chatMediator = new ChatMediatorImpl();

        User u1 = new ChatUser("Bharath", chatMediator);
        User u2 = new ChatUser("Prasanna",chatMediator);
        User u3 = new ChatUser("Mahesh", chatMediator);
        User u4 = new ChatUser("Jags", chatMediator);
        User u5 = new ChatUser("VJ", chatMediator);

        chatMediator.addUser(u1);
        chatMediator.addUser(u2);
        chatMediator.addUser(u3);
        chatMediator.addUser(u4);
        chatMediator.addUser(u5);

        u5.send("Hey guys!!");
        u1.send("hey , what's up?");
    }
}
