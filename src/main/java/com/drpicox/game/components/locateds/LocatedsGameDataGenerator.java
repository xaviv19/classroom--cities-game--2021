package com.drpicox.game.components.locateds;

import com.drpicox.game.components.docks.DocksController;
import com.drpicox.game.components.owneds.OwnedsController;
import com.drpicox.game.ecs.EcsComponent;
import com.drpicox.game.ecs.EntityVisibleDataGenerator;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.ecs.GameVisibleDataGenerator;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocatedsGameDataGenerator implements GameVisibleDataGenerator {

    private final LocatedsRepository locatedsRepository;
    private final OwnedsController ownedsController;
    private final DocksController docksController;
    private final List<EntityVisibleDataGenerator> entityDataGenerators;

    public LocatedsGameDataGenerator(LocatedsRepository locatedsRepository, OwnedsController ownedsController, DocksController docksController, List<EntityVisibleDataGenerator> entityDataGenerators) {
        this.locatedsRepository = locatedsRepository;
        this.ownedsController = ownedsController;
        this.docksController = docksController;
        this.entityDataGenerators = entityDataGenerators;
    }

    @Override
    public void generateVisibleData(GameData data, Player playingPlayer) {
        var owneds = ownedsController.findAllByOwner(playingPlayer);
        var ownedEntityIds = getIds(owneds);

        var locateds = locatedsRepository.findAllById(ownedEntityIds);
        var locations = locateds.stream().map(l -> l.getLocation()).collect(Collectors.toSet());

        var coLocateds = locatedsRepository.findAllByLocationIn(locations);
        var coLocatedsEntityIds = getIds(coLocateds);

        entityDataGenerators.forEach(g -> g.generateVisibleData(data, playingPlayer, coLocatedsEntityIds));
    }

    private static <T extends EcsComponent> List<String> getIds(List<T> components) {
        return components.stream().map(c -> c.getEntityId()).collect(Collectors.toList());
    }
}
