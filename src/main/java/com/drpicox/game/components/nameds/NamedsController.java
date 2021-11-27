package com.drpicox.game.components.nameds;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NamedsController {

    private final NamedsRepository namedsRepository;

    public NamedsController(NamedsRepository namedsRepository) {
        this.namedsRepository = namedsRepository;
    }

    public void create(String entityId, String initialName) {
        var component = new Named(entityId, initialName);
        namedsRepository.save(component);
    }

    public Named changeName(String entityId, String newName) {
        var named = namedsRepository.findById(entityId).get();
        named.changeName(newName);
        namedsRepository.save(named);
        return named;
    }

    public String getName(String entityId) {
        return namedsRepository.findById(entityId).get().getName();
    }

    public List<Named> findAllByName(String name) {
        return namedsRepository.findAllByName(name);
    }
}
