package com.drpicox.game.components.owneds;

import com.drpicox.game.ecs.EntityVisibleDataGenerator;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OwnedsEntityDataGenerator implements EntityVisibleDataGenerator {

    private final OwnedsRepository ownedsRepository;

    public OwnedsEntityDataGenerator(OwnedsRepository ownedsRepository) {
        this.ownedsRepository = ownedsRepository;
    }

    @Override
    public void generateVisibleData(GameData data, Player playingPlayer, List<String> entityIds) {
        var playerOwneds = ownedsRepository.findAllById(entityIds);
        playerOwneds.forEach(component -> {
            var entityId = component.getEntityId();
            data.putEntityProperty(entityId, "isOwned", true);
            data.putEntityProperty(entityId, "owner", component.getOwner().getPlayerName());
        });
    }
}
