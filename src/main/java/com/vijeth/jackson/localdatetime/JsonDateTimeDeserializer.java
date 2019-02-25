package com.vijeth.jackson.localdatetime;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;


public class JsonDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonParser jp, DeserializationContext context) throws IOException {

        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();

        String[] patterns = {"yyyy-MM-dd HH:mm:ss","yyyy/MM/dd HH:mm:ss","yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd"};

        for(String pattern : patterns) {
            builder.appendOptional(DateTimeFormatter.ofPattern(pattern));
        }

        builder.parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0);

        return LocalDateTime.parse(jp.readValueAs(String.class),  builder.toFormatter());
    }
}