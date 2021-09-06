package com.drpicox.game.testSteps.helpers;

import com.drpicox.game.games.api.EntityResponse;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.nameds.api.NamedResponse;
import com.drpicox.game.owneds.api.OwnedResponse;
import com.drpicox.game.typeds.api.TypedResponse;

import java.util.List;
import java.util.stream.Collectors;

public class CitiesHelper {
    public static List<EntityResponse> findAllByOwner(GameResponse gameResponse, String playerName) {
        return findAll(gameResponse).stream()
                .filter(c -> c.getComponent(OwnedResponse.class).hasOwner(playerName))
                .collect(Collectors.toList());
    }

    private static List<EntityResponse> findAll(GameResponse gameResponse) {
        return gameResponse.getEntityResponses().stream()
                .filter(e -> e.getComponent(TypedResponse.class).hasEntityType("city"))
                .map(c -> (EntityResponse) c)
                .collect(Collectors.toList());
    }

    public static EntityResponse findByOwnerAndName(GameResponse game, String ownerName, String cityName) {
        return findAllByOwner(game, ownerName).stream()
                .filter(c -> c.getComponent(NamedResponse.class).hasName(cityName))
                .findFirst().orElseThrow(
                () -> new AssertionError("Cannot find city owner:" + ownerName + ", name:" + cityName)
        );
    }

    public static EntityResponse findById(GameResponse game, String cityId) {
        return (EntityResponse) game.findEntityById(cityId).orElseThrow(
                () -> new AssertionError("Cannot find city by id:" + cityId)
        );
    }
}
