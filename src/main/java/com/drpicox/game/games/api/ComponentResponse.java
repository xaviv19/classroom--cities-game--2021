package com.drpicox.game.games.api;

import com.google.gson.annotations.SerializedName;

public class ComponentResponse {
    @SerializedName("type")
    private String typeName;

    private String id;

    public ComponentResponse(String id) {
        this();
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public ComponentResponse() {
        typeName = getClass().getName();
    }

    public String getId() {
        return id;
    }

    public boolean hasId(String id) {
        return this.id.equals(id);
    }
}
