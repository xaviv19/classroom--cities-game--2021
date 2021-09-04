package com.drpicox.game.testSteps.helpers;

import com.drpicox.game.cities.api.CityResponse;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.ships.api.ShipResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ShipsHelper {

    public static List<ShipResponse> findAllByOwner(CityResponse city, String ownerName) {
        return findAll(city).stream().filter(s -> s.hasOwner(ownerName)).collect(Collectors.toList());
    }

    private static List<ShipResponse> findAll(CityResponse city) {
        return city.getEntities().stream()
                .filter(e -> e instanceof  ShipResponse)
                .map(e -> (ShipResponse) e)
                .collect(Collectors.toList());
    }

    public static ShipResponse findByOwnerAndName(CityResponse city, String ownerName, String shipName) {
        return findAllByOwner(city, ownerName).stream()
                .filter(s -> s.hasName(shipName))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Cannot find ship owner:" + ownerName + "name:" + shipName));
    }

    public static ShipResponse findById(GameResponse game, long shipId) {
        return (ShipResponse) game.findEntityById(shipId).orElseThrow(
                () -> new AssertionError("Cannot find ship by id:" + shipId)
        );
    }
}
