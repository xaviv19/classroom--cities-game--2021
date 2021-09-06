package com.drpicox.game.testSteps.helpers;

import com.drpicox.game.dockables.api.DockableResponse;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.nameds.api.NamedResponse;
import com.drpicox.game.owneds.api.OwnedResponse;
import com.drpicox.game.ships.api.ShipResponse;

import java.util.List;
import java.util.stream.Collectors;

import static com.drpicox.game.dockables.api.DockableResponse.byDockId;
import static com.drpicox.game.nameds.api.NamedResponse.byName;
import static com.drpicox.game.owneds.api.OwnedResponse.byOwner;

public class ShipsHelper {

    public static List<ShipResponse> findAllByOwner(GameResponse gameResponse, String cityId, String ownerName) {
        return findAll(gameResponse, cityId).stream()
                .filter(byOwner(ownerName))
                .collect(Collectors.toList());
    }

    private static List<ShipResponse> findAll(GameResponse gameResponse, String dockId) {
        return gameResponse.streamEntities()
                .filter(byDockId(dockId))
                .filter(e -> e instanceof  ShipResponse)
                .map(e -> (ShipResponse) e)
                .collect(Collectors.toList());
    }

    public static ShipResponse findByOwnerAndName(GameResponse gameResponse, String cityId, String ownerName, String shipName) {
        return findAllByOwner(gameResponse, cityId, ownerName).stream()
                .filter(byName(shipName))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Cannot find ship owner:" + ownerName + "name:" + shipName));
    }

    public static ShipResponse findById(GameResponse game, String shipId) {
        return (ShipResponse) game.findEntityById(shipId).orElseThrow(
                () -> new AssertionError("Cannot find ship by id:" + shipId)
        );
    }
}
