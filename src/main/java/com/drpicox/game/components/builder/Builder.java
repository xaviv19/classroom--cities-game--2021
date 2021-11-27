package com.drpicox.game.components.builder;

import com.drpicox.game.ecs.EcsComponent;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Builder extends EcsComponent {
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> buildeableBuildings = new ArrayList<>();

    public Builder(String entityId, List<String> buildeableBuildings) {
        super(entityId);
        this.buildeableBuildings.addAll(buildeableBuildings);
    }

    protected Builder() {}

    public List<String> getBuildeableBuildings() {
        return buildeableBuildings;
    }
}
