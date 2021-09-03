package com.drpicox.game;

import com.google.gson.*;

import java.lang.reflect.Type;

public class JsonDeserializerWithInheritance<T> implements JsonDeserializer<T>, JsonSerializer<T> {

    @Override
    public T deserialize(
            JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        var jsonObject = json.getAsJsonObject();
        var classNamePrimitive = (JsonPrimitive) jsonObject.get("type");

        String className = classNamePrimitive.getAsString();

        Class<?> clazz;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new JsonParseException(e.getMessage());
        }
        return context.deserialize(jsonObject, clazz);
    }

    @Override
    public JsonElement serialize(T object, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(object, object.getClass());
    }
}
