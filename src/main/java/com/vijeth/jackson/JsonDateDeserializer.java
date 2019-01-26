package com.vijeth.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JsonDateDeserializer extends JsonDeserializer <LocalDate> {
    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException{
        ObjectCodec oc = jsonParser.getCodec();
        TextNode node = oc.readTree(jsonParser);
        String dateString = node.textValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(dateString, formatter);
    }
}