package com.drpicox.game.components.withBuildings;

import com.drpicox.game.ecs.EcsComponent;
import com.drpicox.game.games.Game;

import javax.persistence.Entity;

@Entity
public class WithBuildings extends EcsComponent {
    private String orderBuild;
    private int housesCount;

    public WithBuildings(String entityId, Game game) {
        super(entityId, game);
    }

    protected WithBuildings() {}

    public int getBuildingHouses() {
        return housesCount;
    }

    public boolean isBuildHouseOrdered() {
        return orderBuild != null;
    }

    void orderBuild(String type) {
        orderBuild = type;
    }

    public void build() {
        housesCount += 1;
        orderBuild = null;
    }
}
