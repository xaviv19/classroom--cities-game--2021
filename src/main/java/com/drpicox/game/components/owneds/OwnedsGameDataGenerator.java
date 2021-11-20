package com.drpicox.game.components.owneds;

import com.drpicox.game.ecs.EntityOwnDataGenerator;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.ecs.GameOwnDataGenerator;
import com.drpicox.game.games.Game;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OwnedsGameDataGenerator implements GameOwnDataGenerator {

    private final OwnedsRepository ownedsRepository;
    private final List<EntityOwnDataGenerator> entityOwnDataGenerators;

    public OwnedsGameDataGenerator(OwnedsRepository ownedsRepository, List<EntityOwnDataGenerator> entityOwnDataGenerators) {
        this.ownedsRepository = ownedsRepository;
        this.entityOwnDataGenerators = entityOwnDataGenerators;
    }

    @Override
    public void generateOwnData(GameData data, Player playingPlayer) {
        var playerOwneds = ownedsRepository.findAllByOwner(playingPlayer);
        var ownedEntityIds = playerOwneds.stream().map(c -> c.getEntityId()).collect(Collectors.toList());
        entityOwnDataGenerators.forEach(generator ->
            generator.generateOwnData(data, playingPlayer, ownedEntityIds)
        );
    }
}
