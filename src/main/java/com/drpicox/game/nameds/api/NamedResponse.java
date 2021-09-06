package com.drpicox.game.nameds.api;

import com.drpicox.game.games.api.ComponentResponse;
import com.drpicox.game.games.api.EntityResponse;
import com.drpicox.game.nameds.Named;

import java.util.function.Function;
import java.util.function.Predicate;

public class NamedResponse extends ComponentResponse {
    private String name;

    public NamedResponse(Named named) {
        super(named.getEntityId());
        this.name = named.getName();
    }

    public static Predicate<EntityResponse> byName(String shipName) {
        return e -> e.getComponent(NamedResponse.class).getName().equals(shipName);
    }


    public String getName() {
        return this.name;
    }

    public boolean hasName(String name) {
        return this.name.equals(name);
    }

    public static Function<EntityResponse,String> toName() {
        return e -> e.getComponent(NamedResponse.class).getName();
    }

}
