package com.drpicox.game.components.populateds;

import com.drpicox.game.ecs.ComponentResponse;

public class PopulatedResponse extends ComponentResponse {
    private int population;

    public PopulatedResponse(Populated populated) {
        super(populated.getEntityId());
        this.population = populated.getPopulation();
    }

    public  int getPopulation() {
        return this.population;
    }
}
