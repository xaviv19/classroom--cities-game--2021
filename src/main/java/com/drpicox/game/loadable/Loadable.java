package com.drpicox.game.loadable;

import com.drpicox.game.ecs.EcsComponent;
import com.drpicox.game.games.Game;

import javax.persistence.Entity;

@Entity
public class Loadable extends EcsComponent {
    private int loadUnloadAmount;

    public Loadable(String entityId, Game game) {
        super(entityId, game);
    }

    protected Loadable() {}

    public int getLoadUnloadAmount() {
        return this.loadUnloadAmount;
    }

    void changeLoadUnloadAmount(int newLoadUnloadAmount) {
        this.loadUnloadAmount = newLoadUnloadAmount;
    }

    void clearLoadUnloadAmount() {
        this.loadUnloadAmount = 0;
    }
}
