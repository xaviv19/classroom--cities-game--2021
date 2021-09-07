package com.drpicox.game.ecs;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EntityIdGenerator {
    public String nextEntityId() {
        return UUID.randomUUID().toString();
    }
}
