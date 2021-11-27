package com.drpicox.game.components.containeds;

import com.drpicox.game.components.owneds.OwnedsController;
import com.drpicox.game.ecs.EntityOwnDataGenerator;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.ecs.GameOwnDataGenerator;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContainedsGameDataGenerator implements GameOwnDataGenerator {

    private final List<EntityOwnDataGenerator> entityOwnDataGenerators;
    private final OwnedsController ownedsController;
    private final ContainedsRepository containedsRepository;

    public ContainedsGameDataGenerator(List<EntityOwnDataGenerator> entityOwnDataGenerators, OwnedsController ownedsController, ContainedsRepository containedsRepository) {
        this.entityOwnDataGenerators = entityOwnDataGenerators;
        this.ownedsController = ownedsController;
        this.containedsRepository = containedsRepository;
    }

    @Override
    public void generateOwnData(GameData data, Player playingPlayer) {
        var ownsId = ownedsController.findAllByOwner(playingPlayer).stream().map(o -> o.getEntityId()).collect(Collectors.toList());
        var containedsId = containedsRepository.findAllByContainerIdIn(ownsId).stream().map(c -> c.getEntityId()).collect(Collectors.toList());
        entityOwnDataGenerators.forEach(g -> g.generateOwnData(data, playingPlayer, containedsId));
    }


}
