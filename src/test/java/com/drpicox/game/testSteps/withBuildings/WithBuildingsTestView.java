package com.drpicox.game.testSteps.withBuildings;

import com.drpicox.game.testSteps.game.EntityTestView;
import org.springframework.stereotype.Component;

@Component
public class WithBuildingsTestView {

    private final EntityTestView entityTestView;

    public WithBuildingsTestView(EntityTestView entityTestView) {
        this.entityTestView = entityTestView;
    }

    public int getBuildingCount(String type) {
        var building = "building" + type.substring(0, 1).toUpperCase() + type.substring(1);
        return entityTestView.getEntityPropertyInt(building);
    }

    public void orderBuildHouse() {
        entityTestView.putFormKey("buildingType", "house");
        entityTestView.post("with-buildings", "order-build");
    }
}
