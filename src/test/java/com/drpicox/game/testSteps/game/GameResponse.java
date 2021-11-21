package com.drpicox.game.testSteps.game;

import com.drpicox.game.testSteps.entities.EntityResponse;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameResponse {
    private String playerName;
    private int roundNumber;
    private Map<String, EntityResponse> entities = new TreeMap<>();

    public String getPlayerName() {
        return this.playerName;
    }

    public Stream<EntityResponse> streamEntities() {
        return entities.values().stream();
    }

    public Stream<EntityResponse> streamEntities(Predicate<EntityResponse> predicate) {
        return streamEntities().filter(predicate);
    }

    public Stream<String> streamOwnerNameType() {
        return streamEntities().map(EntityResponse::getOnwerNameType);
    }

    public Optional<EntityResponse> findEntityById(String id) {
        return Optional.ofNullable(entities.get(id));
    }

    public EntityResponse getEntity(String entityId) {
        return findEntityById(entityId).orElseThrow(() ->
                new AssertionError(
                        "There is no entity '"+entityId+"'. " +
                                "Available entities are: " + listEntities()
                )
        );
    }

    public EntityResponse getEntityByOwnerNameType(String owner, String name, String type) {
        var ownerNameType = owner + "-" + name + "-" + type;
        var response = streamEntities().filter(e -> e.getOnwerNameType().equals((ownerNameType))).findAny();
        return response.orElseThrow(() ->
            new AssertionError("There is no entity with:" +
                "\n owner: '"+owner+"'," +
                "\n name:  '"+name+"'," +
                "\n type:  '"+type+"'." +
                "Available entities are: " + listEntities()
            )
        );
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public String listEntities() {
        var result = streamEntities()
                .map(e -> "\n- " + e.getId() + " ("+e.getOnwerNameType()+")")
                .collect(Collectors.joining());
        if (result.length() == 0) return "\n- No entity found.";
        return result;
    }
}
