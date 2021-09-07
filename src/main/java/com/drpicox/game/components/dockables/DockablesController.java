package com.drpicox.game.components.dockables;

import com.drpicox.game.games.Game;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DockablesController {

    private final DockablesRepository dockablesRepository;

    public DockablesController(DockablesRepository dockablesRepository) {
        this.dockablesRepository = dockablesRepository;
    }

    public void create(String entityId, Game game, String dockId) {
        var component = new Dockable(entityId, game, dockId);
        dockablesRepository.save(component);
    }

    public List<Dockable> findAllByGame(Game game) {
        return dockablesRepository.findAllByGame(game);
    }

    public String getDockId(String entityId) {
        return dockablesRepository.findById(entityId).get().getDockId();
    }
}
