package com.drpicox.game.components.quantity;

import com.drpicox.game.components.docks.DocksController;
import com.drpicox.game.ecs.EntityOwnDataGenerator;
import com.drpicox.game.ecs.EntityReachableDataGenerator;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.games.Game;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuantityEntityDataGenerator implements EntityOwnDataGenerator, EntityReachableDataGenerator {

    private final QuantityRepository quantityRepository;
    private final DocksController docksController;

    public QuantityEntityDataGenerator(QuantityRepository quantityRepository, DocksController docksController) {
        this.quantityRepository = quantityRepository;
        this.docksController = docksController;
    }

    @Override
    public void generateOwnData(GameData data, Game game, Player playingPlayer, List<String> ownedEntityIds) {
        generateQuantityData(data, ownedEntityIds);
    }

    @Override
    public void generateReachableData(GameData data, Game game, Player playingPlayer, List<String> reachableEntityIds) {
        var dockIds = docksController.findAllById(reachableEntityIds).stream().map(c -> c.getEntityId()).collect(Collectors.toList());
        generateQuantityData(data, dockIds);
    }

    private void generateQuantityData(GameData data, List<String> ownedEntityIds) {
        var components = quantityRepository.findAllById(ownedEntityIds);
        for (Quantity component : components) {
            var entityId = component.getEntityId();
            data.putEntityProperty(entityId, "quantity", component.getQuantity());
        }
    }
}
