package com.drpicox.game.games.api;

import com.drpicox.game.JsonDeserializerWithInheritance;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

@JsonAdapter(JsonDeserializerWithInheritance.class)
public abstract class EntityResponse {

    @SerializedName("type")
    private String typeName;

    private long id;

    public EntityResponse(long id) {
        this();
        this.id = id;
    }

    public EntityResponse() {
        typeName = getClass().getName();
    }

    public long getId() {
        return id;
    }

    public boolean hasId(long id) {
        return this.id == id;
    }
}
