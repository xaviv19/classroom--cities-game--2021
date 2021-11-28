package com.drpicox.game.components.docks;

import com.drpicox.game.components.locateds.LocatedsController;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

import static com.drpicox.game.ecs.EcsComponent.toId;

@Component
public class DocksController {

    private final DocksRepository docksRepository;
    private final LocatedsController locatedsController;

    public DocksController(DocksRepository docksRepository, LocatedsController locatedsController) {
        this.docksRepository = docksRepository;
        this.locatedsController = locatedsController;
    }

    public void create(String entityId) {
        var component = new Dock(entityId);
        docksRepository.save(component);
    }

    public Optional<Dock> findDockOf(String entityId) {
        var locatedsId = locatedsController.findByLocationOf(entityId).stream().map(toId()).collect(Collectors.toList());
        var docks = docksRepository.findAllById(locatedsId);
        return docks.stream().findAny();
    }
}
