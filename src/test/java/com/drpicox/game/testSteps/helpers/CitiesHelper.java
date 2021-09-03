package com.drpicox.game.testSteps.helpers;

import com.drpicox.game.cities.api.CityResponse;
import com.drpicox.game.games.api.GameResponse;

import java.util.List;
import java.util.stream.Collectors;

public class CitiesHelper {
    public static List<CityResponse> findAllByOwner(GameResponse gameResponse, String playerName) {
        return findAll(gameResponse).stream()
                .filter(c -> c.hasOwner(playerName))
                .collect(Collectors.toList());
    }

    private static List<CityResponse> findAll(GameResponse gameResponse) {
        return gameResponse.getEntityResponses().stream()
                .filter(e -> e instanceof CityResponse)
                .map(c -> (CityResponse) c)
                .collect(Collectors.toList());
    }

    public static CityResponse findByOwnerAndName(GameResponse game, String ownerName, String cityName) {
        return findAllByOwner(game, ownerName).stream().filter(c -> c.hasName(cityName)).findFirst().orElseThrow(
                () -> new AssertionError("Cannot find city owner:" + ownerName + ", name:" + cityName)
        );
    }

    public static CityResponse findById(GameResponse game, long cityId) {
        return (CityResponse) game.findEntityById(cityId).orElseThrow(
                () -> new AssertionError("Cannot find city by id:" + cityId)
        );
    }
}
