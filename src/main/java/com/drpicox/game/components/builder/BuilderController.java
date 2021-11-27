package com.drpicox.game.components.builder;

import com.drpicox.game.components.containeds.ContainedsController;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuilderController {

    private final BuildersRepository buildersRepository;
    private final ContainedsController containedsController;
    private final List<BuilderFactory> builderBuildingFactories;

    public BuilderController(BuildersRepository buildersRepository, ContainedsController containedsController, List<BuilderFactory> builderBuildingFactories) {
        this.buildersRepository = buildersRepository;
        this.containedsController = containedsController;
        this.builderBuildingFactories = builderBuildingFactories;
    }

    public void create(String entityId, String type) {
        var buildings = builderBuildingFactories.stream()
                .filter(b -> b.getType().equals(type))
                .map(b -> b.getName()).collect(Collectors.toList());
        var component = new Builder(entityId, buildings);
        buildersRepository.save(component);
    }

    public void build(String entityId, String buildingName) {
        var containerId = containedsController.getContainerId(entityId);
        var factory = builderBuildingFactories.stream()
                .filter(f -> f.getName().equals(buildingName))
                .findAny().get();

        factory.build(containerId);
    }
}
