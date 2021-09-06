package com.drpicox.game.cities;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.GameJoiner;
import com.drpicox.game.growsPopulation.GrowsPopulationsController;
import com.drpicox.game.nameds.NamedsController;
import com.drpicox.game.owneds.OwnedsController;
import com.drpicox.game.players.Player;
import com.drpicox.game.populateds.PopulatedsController;
import com.drpicox.game.typed.TypedsController;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CityGameJoiner implements GameJoiner {

    private final NamedsController namedsController;
    private final OwnedsController ownedsController;
    private final PopulatedsController populatedsController;
    private final GrowsPopulationsController growsPopulationsController;
    private final CityRepository cityRepository;
    private final TypedsController typedsController;

    public CityGameJoiner(NamedsController namedsController, OwnedsController ownedsController, PopulatedsController populatedsController, GrowsPopulationsController growsPopulationsController, CityRepository cityRepository, TypedsController typedsController) {
        this.namedsController = namedsController;
        this.ownedsController = ownedsController;
        this.populatedsController = populatedsController;
        this.growsPopulationsController = growsPopulationsController;
        this.cityRepository = cityRepository;
        this.typedsController = typedsController;
    }

    @Override
    public void joinGame(Player owner, Game game) {
        var entityId = UUID.randomUUID().toString();

        namedsController.create(entityId, game, "Capital");
        ownedsController.create(entityId, game, owner);
        populatedsController.create(entityId, game, 10);
        growsPopulationsController.create(entityId, game);
        typedsController.create(entityId, game, "city");

        var city = new City(entityId, game);
        cityRepository.save(city);
    }
}
