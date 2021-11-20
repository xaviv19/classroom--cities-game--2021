package com.drpicox.game.testSteps.game;

import com.drpicox.game.games.Game;
import com.drpicox.game.testSteps.game.entities.EntityResponse;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameResponse {
    private String playerName;
    private int roundNumber;
    private Map<String, EntityResponse> entities = new TreeMap<>();

    public GameResponse(Game game, String playerName) {
        this.roundNumber = game.getRoundNumber();
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public Stream<EntityResponse> streamEntities() {
        return entities.values().stream();
    }

    public Optional<EntityResponse> findEntityById(String id) {
        return Optional.ofNullable(entities.get(id));
    }

    public EntityResponse getEntity(String entityId) {
        return findEntityById(entityId).orElseThrow(() ->
                new AssertionError(
                        "There is no entity '"+entityId+"', available entities are:\n- " +
                                entities.keySet().stream().collect(Collectors.joining("\n- "))
                )
        );
    }

    public int getRoundNumber() {
        return roundNumber;
    }
}
