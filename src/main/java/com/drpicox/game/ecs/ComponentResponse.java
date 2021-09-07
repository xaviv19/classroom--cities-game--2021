package com.drpicox.game.ecs;

import com.drpicox.game.JsonDeserializerWithInheritance;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

@JsonAdapter(JsonDeserializerWithInheritance.class)
public class ComponentResponse {
    @SerializedName("type")
    private String typeName;

    private String id;

    public ComponentResponse(String id) {
        this();
        this.id = id;
    }

    public ComponentResponse() {
        typeName = getClass().getName();
    }

    public String getId() {
        return id;
    }
}
