package com.drpicox.game.components.containeds;

import org.springframework.stereotype.Component;

@Component
public class ContainedsController {

    private final ContainedsRepository containedsRepository;

    public ContainedsController(ContainedsRepository containedsRepository) {
        this.containedsRepository = containedsRepository;
    }

    public void create(String entityId, String containerId) {
        var component = new Contained(entityId, containerId);
        containedsRepository.save(component);
    }

    public String getContainerId(String entityId) {
        return containedsRepository.findById(entityId).get().getContainerId();
    }
}
