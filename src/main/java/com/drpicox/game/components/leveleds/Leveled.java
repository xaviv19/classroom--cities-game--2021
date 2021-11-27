package com.drpicox.game.components.leveleds;

import com.drpicox.game.ecs.EcsComponent;

import javax.persistence.Entity;

@Entity
public class Leveled extends EcsComponent {
    private int level;

    public Leveled(String entityId) {
        super(entityId);

        this.level = 1;
    }

    public int getLevel() {
        return level;
    }

    protected Leveled(){}

    void upgrade(int levelsUp) {
        this.level += levelsUp;
    }
}
