package com.drpicox.game.components.leveleds;

import com.drpicox.game.components.nameds.NamedsController;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LeveledController {

    private final NamedsController namedsController;
    private final LeveledsRepository leveledsRepository;
    private final List<LeveledUpgrader> leveledUpgraders;

    public LeveledController(NamedsController namedsController, LeveledsRepository leveledsRepository, List<LeveledUpgrader> leveledUpgraders) {
        this.namedsController = namedsController;
        this.leveledsRepository = leveledsRepository;
        this.leveledUpgraders = leveledUpgraders;
    }

    public void create(String entityId) {
        var component = new Leveled(entityId);
        leveledsRepository.save(component);
    }


    public void upgrade(String entityId) {
        var name = namedsController.getName(entityId);
        var upgrader = leveledUpgraders.stream().filter(l -> l.getName().equals(name)).findAny().get();
        var levelsUp = upgrader.upgrade(entityId);

        var leveled = leveledsRepository.findById(entityId).get();
        leveled.upgrade(levelsUp);
        leveledsRepository.save(leveled);
    }
}
