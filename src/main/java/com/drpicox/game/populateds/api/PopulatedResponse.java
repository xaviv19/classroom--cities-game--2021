package com.drpicox.game.populateds.api;

import com.drpicox.game.games.api.ComponentResponse;
import com.drpicox.game.owneds.Owned;
import com.drpicox.game.populateds.Populated;

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
