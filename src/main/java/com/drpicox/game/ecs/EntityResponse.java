package com.drpicox.game.ecs;

import com.google.gson.annotations.JsonAdapter;

import java.util.Map;
import java.util.TreeMap;

@JsonAdapter(EntityResponseDeserializerSerializer.class)
public class EntityResponse {

    private Map<String, Object> properties = new TreeMap<>();

    public EntityResponse(String id) {
        this.properties.put("id", id);
    }

    EntityResponse(Map<String, Object> properties) {
        this.properties = properties;
    }

    public String getId() {
        return (String) properties.get("id");
    }

    public void put(String key, Object value) {
        properties.put(key, value);
    }

    public Object getOrDefault(String key, Object defaultValue) {
        return properties.getOrDefault(key, defaultValue);
    }

    public Object get(String key) {
        return properties.get(key);
    }

    Map<String, Object> getProperties() {
        return this.properties;
    }
}
