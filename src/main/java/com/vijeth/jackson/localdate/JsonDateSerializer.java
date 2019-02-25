package com.vijeth.jackson.localdate;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JsonDateSerializer extends JsonSerializer<LocalDate> {
    @Override
    public void serialize(LocalDate date, JsonGenerator generator, SerializerProvider provider) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        final String dateString = date.format(formatter);
        generator.writeString(dateString);
    }
}
