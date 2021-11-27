package com.drpicox.game.testSteps.components.builders;

import com.drpicox.game.testSteps.entities.EntityTestView;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuilderTestView {
    private final EntityTestView entityTestView;

    public BuilderTestView(EntityTestView entityTestView) {
        this.entityTestView = entityTestView;
    }

    public void build(String name) {
        entityTestView.putFormKey("buildingName", name);
        entityTestView.post("builders", "build");
    }

    public List<String> getBuildeableBuildings() {
        return entityTestView.getEntity().get("buildeableBuildings", List.class);
    }
}
