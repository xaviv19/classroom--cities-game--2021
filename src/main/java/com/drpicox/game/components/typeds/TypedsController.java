package com.drpicox.game.components.typeds;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TypedsController {

    private final TypedsRepository typedsRepository;

    public TypedsController(TypedsRepository typedsRepository) {
        this.typedsRepository = typedsRepository;
    }

    public void create(String entityId, String entityType) {
        var component = new Typed(entityId, entityType);
        typedsRepository.save(component);
    }

    public boolean isTyped(String entityId, String entityType) {
        return typedsRepository.findById(entityId).map(c -> c.isType(entityType)).orElse(false);
    }

    public List<Typed> findAllByType(String type) {
        return typedsRepository.findAllByType(type);
    }
}
