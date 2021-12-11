package com.drpicox.game.testSteps.components.builders;

import com.drpicox.game.components.builder.BuilderFactory;
import com.drpicox.game.components.nameds.NamedsController;
import com.drpicox.game.components.owneds.OwnedsController;
import com.drpicox.game.components.typeds.TypedsController;
import com.drpicox.game.ecs.EcsComponent;
import com.drpicox.game.players.PlayersController;
import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class GivenThatTheHasBuiltAStep extends AbstractPostLineStep {

    private final PlayersController playersController;
    private final OwnedsController ownedsController;
    private final NamedsController namedsController;
    private final TypedsController typedsController;
    private final List<BuilderFactory> builderBuildingFactories;

    public GivenThatTheHasBuiltAStep(PlayersController playersController, OwnedsController ownedsController, NamedsController namedsController, TypedsController typedsController, List<BuilderFactory> builderBuildingFactories) {
        this.playersController = playersController;
        this.ownedsController = ownedsController;
        this.namedsController = namedsController;
        this.typedsController = typedsController;
        this.builderBuildingFactories = builderBuildingFactories;
    }

    @Override
    protected String getRegex() {
        return "Given that the \"([^\"]+)\" \"([^\"]+)\" \"([^\"]+)\" has built a \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var owner = match[1];
        var type = match[2];
        var name = match[3];
        var buildingName = match[4];

        var matchingEntityIds = findAllEntityIdsByOwnerTypeName(owner, type, name);
        buildTheBuilding(matchingEntityIds, buildingName);
    }

    private void buildTheBuilding(Set<String> matchingEntityIds, String buildingName) {
        matchingEntityIds.forEach(containerId -> {
            var factory = builderBuildingFactories.stream()
                    .filter(f -> f.getName().equals(buildingName))
                    .findAny().get();

            factory.build(containerId);
        });
    }

    private Set<String> findAllEntityIdsByOwnerTypeName(String ownerName, String type, String name) {
        var ownerPlayer = playersController.findPlayer(ownerName).get();
        var owneds = ownedsController.findAllByOwner(ownerPlayer).stream().map(this::toId).collect(Collectors.toList());
        var typeds = typedsController.findAllByType(type).stream().map(this::toId).collect(Collectors.toList());
        var nameds = namedsController.findAllByName(name).stream().map(this::toId).collect(Collectors.toList());

        var intersection = new HashSet<>(owneds);
        intersection.retainAll(typeds);
        intersection.retainAll(nameds);
        return intersection;
    }

    private String toId(EcsComponent component) {
        return component.getEntityId();
    }
}
