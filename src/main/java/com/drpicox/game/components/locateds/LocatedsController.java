package com.drpicox.game.components.locateds;

import com.drpicox.game.games.Game;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LocatedsController {

    private final LocatedsRepository locatedsRepository;

    public LocatedsController(LocatedsRepository locatedsRepository) {
        this.locatedsRepository = locatedsRepository;
    }

    public void create(String entityId, Game game, int initialLocation) {
        var component = new Located(entityId, game, initialLocation);
        locatedsRepository.save(component);
    }

    public List<Located> findAllByGame(Game game) {
        return locatedsRepository.findAllByGame(game);
    }

    public List<Located> findByGameAndLocation(Game game, int location) {
        return locatedsRepository.findByGameAndLocation(game, location);
    }

    public int getLocation(String entityId) {
        return locatedsRepository.findById(entityId).get().getLocation();
    }
}
