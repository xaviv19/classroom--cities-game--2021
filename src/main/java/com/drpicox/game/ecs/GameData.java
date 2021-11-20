package com.drpicox.game.ecs;

import java.util.Map;
import java.util.TreeMap;

public class GameData {
    private int roundNumber;
    private String playerName;
    private Map<String, Map<String, Object>> entities = new TreeMap<>();

    public GameData(int roundNumber, String playerName) {
        this.roundNumber = roundNumber;
        this.playerName = playerName;
    }

    public void putEntityProperty(String entityId, String key, Object value) {
        var entity = ensureEntityResponse(entityId);
        entity.put(key, value);
    }

    private Map<String, Object> ensureEntityResponse(String id) {
        var entity = entities.get(id);
        if (entity == null) {
            entity = new TreeMap<>();
            entity.put("id", id);
            entities.put(id, entity);
        }
        return entity;
    }
}
