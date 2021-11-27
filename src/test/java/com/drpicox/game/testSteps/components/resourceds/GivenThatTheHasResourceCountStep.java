package com.drpicox.game.testSteps.components.resourceds;

import com.drpicox.game.components.nameds.NamedsController;
import com.drpicox.game.components.owneds.OwnedsController;
import com.drpicox.game.components.resourceds.ResourceType;
import com.drpicox.game.components.resourceds.ResourcedsController;
import com.drpicox.game.components.typeds.TypedsController;
import com.drpicox.game.ecs.EcsComponent;
import com.drpicox.game.players.PlayersController;
import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.entities.PrettyKey;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class GivenThatTheHasResourceCountStep extends AbstractPostLineStep {

    private final PlayersController playersController;
    private final OwnedsController ownedsController;
    private final NamedsController namedsController;
    private final TypedsController typedsController;
    private final ResourcedsController resourcedsController;

    public GivenThatTheHasResourceCountStep(PlayersController playersController, OwnedsController ownedsController, NamedsController namedsController, TypedsController typedsController, ResourcedsController resourcedsController) {
        this.playersController = playersController;
        this.ownedsController = ownedsController;
        this.namedsController = namedsController;
        this.typedsController = typedsController;
        this.resourcedsController = resourcedsController;
    }

    @Override
    protected String getRegex() {
        return "Given that the \"([^\"]+)\" \"([^\"]+)\" \"([^\"]+)\" has resource _([^_]+)_ count (\\d+)";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var owner = match[1];
        var type = match[2];
        var name = match[3];
        var resourceName = PrettyKey.getKey(match[4]);
        var newValue = Integer.parseInt(match[5]);

        var matchingEntityIds = findAllEntityIdsByOwnerTypeName(owner, type, name);
        replaceResourceCountInMatchingEntities(resourceName, newValue, matchingEntityIds);
    }

    private void replaceResourceCountInMatchingEntities(String resourceName, int newValue, Set<String> matchingEntityIds) {
        var resourceType = ResourceType.findByName(resourceName).get();
        matchingEntityIds.forEach(entityId -> {
            resourcedsController.replaceCount(entityId, resourceType, newValue);
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
