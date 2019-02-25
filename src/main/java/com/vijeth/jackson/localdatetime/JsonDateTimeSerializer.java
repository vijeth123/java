package com.vijeth.jackson.localdatetime;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JsonDateTimeSerializer extends JsonSerializer<LocalDateTime> {
    @Override
    public void serialize(LocalDateTime date, JsonGenerator generator, SerializerProvider provider) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        final String dateString = formatter.format(date);
        generator.writeString(dateString);
    }
}
