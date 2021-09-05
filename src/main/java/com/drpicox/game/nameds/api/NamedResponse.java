package com.drpicox.game.nameds.api;

import com.drpicox.game.games.api.ComponentResponse;
import com.drpicox.game.nameds.Named;

public class NamedResponse extends ComponentResponse {
    private String name;

    public NamedResponse(Named named) {
        super(named.getEntityId());
        this.name = named.getName();
    }

    public String getName() {
        return this.name;
    }

    public boolean hasName(String name) {
        return this.name.equals(name);
    }
}
