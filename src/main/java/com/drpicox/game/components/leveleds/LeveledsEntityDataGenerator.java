package com.drpicox.game.components.leveleds;

import com.drpicox.game.ecs.EntityOwnDataGenerator;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LeveledsEntityDataGenerator implements EntityOwnDataGenerator {

    private final LeveledsRepository leveledsRepository;

    public LeveledsEntityDataGenerator(LeveledsRepository leveledsRepository) {
        this.leveledsRepository = leveledsRepository;
    }

    @Override
    public void generateOwnData(GameData data, Player playingPlayer, List<String> entityIds) {
        var components = leveledsRepository.findAllById(entityIds);
        components.forEach(component -> {
            var entityId = component.getEntityId();
            data.putEntityProperty(entityId, "level", component.getLevel());
        });
    }
}
