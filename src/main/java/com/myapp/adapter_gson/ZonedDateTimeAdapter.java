package com.myapp.adapter_gson;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.ZonedDateTime;

public class ZonedDateTimeAdapter implements JsonSerializer<ZonedDateTime>, JsonDeserializer<ZonedDateTime> {
    @Override
    public JsonElement serialize(ZonedDateTime zonedDateTime, Type type,
                                 JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(zonedDateTime.toString());
    }

    @Override
    public ZonedDateTime deserialize(JsonElement json, Type type,
                                     JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException {
        return ZonedDateTime.parse(json.getAsString());
    }
}
