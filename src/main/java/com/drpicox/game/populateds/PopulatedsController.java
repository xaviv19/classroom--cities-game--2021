package com.drpicox.game.populateds;

import com.drpicox.game.games.Game;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PopulatedsController {

    private final PopulatedsRepository populatedsRepository;

    public PopulatedsController(PopulatedsRepository populatedsRepository) {
        this.populatedsRepository = populatedsRepository;
    }

    public Populated create(String entityId, Game game, int initialPopulation) {
        var component = new Populated(entityId, game, initialPopulation);
        populatedsRepository.save(component);
        return component;
    }

    public List<Populated> findAllByGame(Game game) {
        return populatedsRepository.findAllByGame(game);
    }

    public void increasePopulation(String entityId, int increment) {
        var populated = populatedsRepository.findById(entityId).get();
        populated.increasePopulation(increment);
        populatedsRepository.save(populated);
    }
}
