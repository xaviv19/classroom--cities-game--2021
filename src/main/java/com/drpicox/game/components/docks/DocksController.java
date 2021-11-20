package com.drpicox.game.components.docks;

import org.springframework.stereotype.Component;

import java.util.List;

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

    public List<Dock> findAll() {
        return docksRepository.findAll();
    }

    public List<Dock> findAllById(List<String> entityIds) {
        return docksRepository.findAllById(entityIds);
    }
}
