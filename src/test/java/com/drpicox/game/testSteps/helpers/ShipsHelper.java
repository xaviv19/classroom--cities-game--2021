package com.drpicox.game.testSteps.helpers;

import com.drpicox.game.cities.api.CityResponse;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.nameds.api.NamedResponse;
import com.drpicox.game.owneds.api.OwnedResponse;
import com.drpicox.game.ships.api.ShipResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ShipsHelper {

    public static List<ShipResponse> findAllByOwner(GameResponse gameResponse, CityResponse city, String ownerName) {
        return findAll(gameResponse, city).stream().filter(e -> e.getComponent(OwnedResponse.class).hasOwner(ownerName)).collect(Collectors.toList());
    }

    private static List<ShipResponse> findAll(GameResponse gameResponse, CityResponse city) {
        return city.getEntities().stream()
                .map(draft -> gameResponse.getEntityResponse(draft.getId()))
                .filter(e -> e instanceof  ShipResponse)
                .map(e -> (ShipResponse) e)
                .collect(Collectors.toList());
    }

    public static ShipResponse findByOwnerAndName(GameResponse gameResponse, CityResponse city, String ownerName, String shipName) {
        return findAllByOwner(gameResponse, city, ownerName).stream()
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
