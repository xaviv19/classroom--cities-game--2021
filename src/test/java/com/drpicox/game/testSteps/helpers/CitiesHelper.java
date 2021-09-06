package com.drpicox.game.testSteps.helpers;

import com.drpicox.game.games.api.EntityResponse;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.nameds.api.NamedResponse;
import com.drpicox.game.owneds.api.OwnedResponse;
import com.drpicox.game.typeds.api.TypedResponse;

import java.util.List;
import java.util.stream.Collectors;

import static com.drpicox.game.nameds.api.NamedResponse.byName;
import static com.drpicox.game.owneds.api.OwnedResponse.byOwner;
import static com.drpicox.game.typeds.api.TypedResponse.byEntityType;

public class CitiesHelper {
    public static List<EntityResponse> findAllByOwner(GameResponse gameResponse, String playerName) {
        return findAll(gameResponse).stream()
                .filter(byOwner(playerName))
                .collect(Collectors.toList());
    }

    private static List<EntityResponse> findAll(GameResponse gameResponse) {
        return gameResponse.streamEntities()
                .filter(byEntityType("city"))
                .collect(Collectors.toList());
    }

    public static EntityResponse findByOwnerAndName(GameResponse game, String ownerName, String cityName) {
        return findAllByOwner(game, ownerName).stream()
                .filter(byName(cityName))
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
