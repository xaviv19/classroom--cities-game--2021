package com.drpicox.game.testSteps.helpers;

import com.drpicox.game.games.api.EntityResponse;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.nameds.api.NamedResponse;
import com.drpicox.game.owneds.api.OwnedResponse;
import com.drpicox.game.ships.api.ShipResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ShipsHelper {

    public static List<ShipResponse> findAllByOwner(GameResponse gameResponse, String cityId, String ownerName) {
        return findAll(gameResponse, cityId).stream().filter(e -> e.getComponent(OwnedResponse.class).hasOwner(ownerName)).collect(Collectors.toList());
    }

    private static List<ShipResponse> findAll(GameResponse gameResponse, String cityId) {
        return gameResponse.getEntityResponses().stream()
                .filter(e -> e instanceof  ShipResponse)
                .map(e -> (ShipResponse) e)
                .filter(e -> e.getCityId().equals(cityId))
                .collect(Collectors.toList());
    }

    public static ShipResponse findByOwnerAndName(GameResponse gameResponse, String cityId, String ownerName, String shipName) {
        return findAllByOwner(gameResponse, cityId, ownerName).stream()
                .filter(e -> e.getComponent(NamedResponse.class).hasName(shipName))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Cannot find ship owner:" + ownerName + "name:" + shipName));
    }

    public static ShipResponse findById(GameResponse game, String shipId) {
        return (ShipResponse) game.findEntityById(shipId).orElseThrow(
                () -> new AssertionError("Cannot find ship by id:" + shipId)
        );
    }
}
