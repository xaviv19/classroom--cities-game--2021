package com.drpicox.game.testSteps.wall;

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
public class WallTestView {
    private final EntityTestView entityTestView;
    private final GameTestView gameTestView;
    private final QuantityTestView quantityTestView;
    private final TypedTestView typedTestView;
    private final OwnedTestView ownedTestView;

    public WallTestView(OwnedTestView ownedTestView, EntityTestView entityTestView, GameTestView gameTestView, QuantityTestView quantityTestView, TypedTestView typedTestView) {
        this.entityTestView = entityTestView;
        this.gameTestView = gameTestView;
        this.quantityTestView = quantityTestView;
        this.typedTestView = typedTestView;
        this.ownedTestView = ownedTestView;
    }

    public void createWall() {
        var sourceEntityIdWall = getWallSourceEntityId();
        /*
        var sourceEntityIdWood = getMaterialSourceEntityId("WOOD");
        var sourceEntityIdStone = getMaterialSourceEntityId("STONE");
         */
        entityTestView.createWall("quantity", "createWall", sourceEntityIdWall);
    }

    private String getWallSourceEntityId() {
        return gameTestView.streamEntities(byTypeWall().and(byOwner(gameTestView.getGame().getPlayerName())))
                .findFirst().get().getId();
    }

    private String getMaterialSourceEntityId(String materialName) {
        return gameTestView.streamEntities(byName(materialName).and(byOwner(gameTestView.getGame().getPlayerName())))
                .findFirst().get().getId();
    }

    public static Predicate<EntityResponse> byTypeWall() {
        return e -> e.getOrDefault("type", "").equals("WALL");
    }

}

