package com.vijeth.design.pattern.creational;


class User{
    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private long phoneNumber;

    private User(UserBuilder userBuilder){
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.age = userBuilder.age;
        this.address = userBuilder.address;
        this.phoneNumber = userBuilder.phoneNumber;
    }

    public static class UserBuilder{
        private String firstName;
        private String lastName;
        private int age;
        private String address;
        private long phoneNumber;

        public UserBuilder(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder age(int age){
            this.age = age;
            return this;
        }
        public UserBuilder address(String address){
            this.address = address;
            return this;
        }
        public UserBuilder phoneNumber(long phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}

public class BuilderTest {
    public static void main(String[] args) {
        User user = new User.UserBuilder("Vijeth", "Devangi").age(30).phoneNumber(912313434).address("Shimoga").build();
        System.out.println(user);
    }
}
