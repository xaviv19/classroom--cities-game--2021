package com.drpicox.game.games.api;

import com.drpicox.game.games.Game;

import java.util.*;

public class GameResponse {
    private String gameName;
    private String creatorName;
    private String playerName;
    private String token;
    private int roundNumber;
    private Map<String, EntityResponse> entities = new LinkedHashMap<>();

    public GameResponse(Game game, String playerName, String token) {
        this.gameName = game.getGameName();
        this.creatorName = game.getCreator().getPlayerName();
        this.roundNumber = game.getRoundNumber();
        this.playerName = playerName;
        this.token = token;
    }

    public String getGameName() {
        return this.gameName;
    }

    public String getCreatorName() {
        return this.creatorName;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public String getToken() {
        return this.token;
    }

    public void addEntity(EntityResponse entityResponse) {
        entities.put(entityResponse.getId(), entityResponse);
    }

    public Collection<EntityResponse> getEntityResponses() {
        return entities.values();
    }

    public Optional<EntityResponse> findEntityById(String id) {
        return Optional.ofNullable(entities.get(id));
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public <T extends EntityResponse> T getEntityResponse(String id) {
        return (T) findEntityById(id).get();
    }

    public void addComponent(ComponentResponse componentResponse) {
        var id = componentResponse.getId();
        entities.get(id).addComponent(componentResponse);
    }
}
