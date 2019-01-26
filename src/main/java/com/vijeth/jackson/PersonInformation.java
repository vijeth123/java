package com.vijeth.jackson;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.LocalDate;

public class PersonInformation {
    private String givenName;
    private int age;

    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDate birthDate;

    public PersonInformation(){}

    public PersonInformation(String givenName, int age, LocalDate birthDate) {
        this.givenName = givenName;
        this.age = age;
        this.birthDate = birthDate;
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

    @Override
    public String toString() {
        return "PersonInformation{" +
                "givenName='" + givenName + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                '}';
    }
}
