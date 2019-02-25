package com.vijeth.jackson;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vijeth.jackson.localdate.JsonDateDeserializer;
import com.vijeth.jackson.localdate.JsonDateSerializer;
import com.vijeth.jackson.localdatetime.JsonDateTimeDeserializer;
import com.vijeth.jackson.localdatetime.JsonDateTimeSerializer;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PersonInformation {
    private String givenName;
    private int age;

    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDate birthDate;

    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    private LocalDateTime lastActiveDateTime;

    public PersonInformation(){}

    public PersonInformation(String givenName, int age, LocalDate birthDate, LocalDateTime lastActiveDateTime) {
        this.givenName = givenName;
        this.age = age;
        this.birthDate = birthDate;
        this.lastActiveDateTime = lastActiveDateTime;
    }

    public String getGivenName() {
        return givenName;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDateTime getLastActiveDateTime() {
        return lastActiveDateTime;
    }

    public void setLastActiveDateTime(LocalDateTime lastActiveDateTime) {
        this.lastActiveDateTime = lastActiveDateTime;
    }

    @Override
    public String toString() {
        return "PersonInformation{" +
                "givenName='" + givenName + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", lastActiveDateTime=" + lastActiveDateTime +
                '}';
    }
}
