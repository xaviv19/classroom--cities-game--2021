package com.drpicox.game.testSteps.house;

import com.drpicox.game.testSteps.game.EntityResponse;
import com.drpicox.game.testSteps.game.EntityTestView;
import com.drpicox.game.testSteps.game.GameTestView;
import com.drpicox.game.testSteps.game.TypedTestView;
import com.drpicox.game.testSteps.owneds.OwnedTestView;
import com.drpicox.game.testSteps.quantity.QuantityTestView;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

import static com.drpicox.game.testSteps.nameds.NamedTestView.byName;
import static com.drpicox.game.testSteps.owneds.OwnedTestView.byOwner;


@Component
public class HouseTestView {
    private final EntityTestView entityTestView;
    private final GameTestView gameTestView;
    private final QuantityTestView quantityTestView;
    private final TypedTestView typedTestView;
    private final OwnedTestView ownedTestView;

    public HouseTestView(OwnedTestView ownedTestView, EntityTestView entityTestView, GameTestView gameTestView, QuantityTestView quantityTestView, TypedTestView typedTestView) {
        this.entityTestView = entityTestView;
        this.gameTestView = gameTestView;
        this.quantityTestView = quantityTestView;
        this.typedTestView = typedTestView;
        this.ownedTestView = ownedTestView;
    }

    public void createHouse() {
        var sourceEntityIdHouse = getHouseSourceEntityId();
        var sourceEntityIdWood = getMaterialSourceEntityId("WOOD");
        var sourceEntityIdStone = getMaterialSourceEntityId("STONE");
        entityTestView.createHouse("quantity", "createHouse", sourceEntityIdHouse, sourceEntityIdWood, 20, sourceEntityIdStone, 35);
    }

    private String getHouseSourceEntityId() {
        return gameTestView.streamEntities(byTypeHouse().and(byOwner(gameTestView.getGame().getPlayerName())))
                .findFirst().get().getId();
    }

    private String getMaterialSourceEntityId(String materialName) {
        return gameTestView.streamEntities(byName(materialName).and(byOwner(gameTestView.getGame().getPlayerName())))
                .findFirst().get().getId();
    }

    public static Predicate<EntityResponse> byTypeHouse() {
        return e -> e.getOrDefault("type", "").equals("HOUSE");
    }

}
