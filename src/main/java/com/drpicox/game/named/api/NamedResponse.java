package com.drpicox.game.named.api;

import com.drpicox.game.cities.City;
import com.drpicox.game.games.api.ComponentResponse;
import com.drpicox.game.games.api.EntityResponse;
import com.drpicox.game.named.Named;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NamedResponse extends ComponentResponse {
    private String name;

    public NamedResponse(Named named) {
        super(named.getEntityId());
        this.name = named.getName();
    }

    public String getName() {
        return this.name;
    }
}
