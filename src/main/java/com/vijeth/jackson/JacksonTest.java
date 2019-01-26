package com.vijeth.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/*
 * Java Program to parse JSON with date attribute using Jackson
 */
public class JacksonTest {
    private static String json = "{\r\n" + "\"givenName\" : \"Vijeth\",\r\n"
            + "\"age\" : \"29\",\r\n"
            + "\"birthDate\" : \"07-03-1988\"\r\n" + "}";

    public static void main(String args[]) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        PersonInformation personInformation = mapper.readValue(json, PersonInformation.class);
        System.out.println("Input json string: "+json);
        System.out.println("Generated person information: "+personInformation);
    }
}
