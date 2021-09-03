package com.drpicox.game.games.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GameResponse {
    private String gameName;
    private String creatorName;
    private String playerName;
    private String token;
    private List<EntityResponse> entityResponses = new ArrayList<>();

    public GameResponse(String gameName, String creatorName, String playerName, String token) {
        this.gameName = gameName;
        this.creatorName = creatorName;
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
        entityResponses.add(entityResponse);
    }

    public List<EntityResponse> getEntityResponses() {
        return entityResponses;
    }

    public Optional<EntityResponse> findEntityById(long id) {
        return entityResponses.stream().filter(e -> e.hasId(id)).findFirst();
    }
}
