package com.drpicox.game.games.api;

import com.drpicox.game.JsonDeserializerWithInheritance;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

@JsonAdapter(JsonDeserializerWithInheritance.class)
public abstract class EntityResponse extends AbstractResponse {

    @SerializedName("type")
    private String typeName;

    private String id;

    private Map<String, ComponentResponse> components = new LinkedHashMap<>();

    public EntityResponse(String id) {
        this();
        this.id = id;
    }

    private EntityResponse() {
        typeName = getClass().getName();
    }

    public String getId() {
        return id;
    }

    public void addComponent(ComponentResponse componentResponse) {
        var componentClass = componentResponse.getClass();
        this.components.put(getKey(componentClass), componentResponse);
    }

    private String getKey(Class<? extends ComponentResponse> componentClass) {
        var capital = componentClass.getSimpleName().replaceFirst("Response$", "");
        var key = capital.substring(0, 1).toLowerCase() + capital.substring(1);
        return key;
    }

    public <T extends ComponentResponse> Optional<T> getComponent(Class<T> componentClass) {
        var key = getKey(componentClass);
        return Optional.ofNullable((T) components.get(key));
    }
}
