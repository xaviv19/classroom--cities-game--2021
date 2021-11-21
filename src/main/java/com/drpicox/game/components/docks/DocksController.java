package com.drpicox.game.components.docks;

import org.springframework.stereotype.Component;

@Component
public class DocksController {

    private final DocksRepository docksRepository;

    public DocksController(DocksRepository docksRepository) {
        this.docksRepository = docksRepository;
    }

    public void create(String entityId) {
        var component = new Dock(entityId);
        docksRepository.save(component);
    }
}
