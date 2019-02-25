package com.vijeth.jackson.localdate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class JsonDateDeserializer extends JsonDeserializer <LocalDate> {
    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException{
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();

        String[] patterns = {"yyyy-MM-dd", "dd-MM-yyyy", "yyyy/MM/dd", "dd/MM/yyyy"};

        for(String pattern : patterns) {
            builder.appendOptional(DateTimeFormatter.ofPattern(pattern));
        }
        return LocalDate.parse(jsonParser.readValueAs(String.class),  builder.toFormatter());
    }
}