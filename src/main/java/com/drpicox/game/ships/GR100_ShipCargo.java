package com.drpicox.game.ships;

import com.drpicox.game.cities.CityController;
import com.drpicox.game.games.Game;
import com.drpicox.game.games.GameRounder;
import com.drpicox.game.populateds.PopulatedsController;
import org.springframework.stereotype.Component;

@Component
public class GR100_ShipCargo implements GameRounder {

    private final PopulatedsController populatedsController;
    private final ShipController shipController;
    private final ShipRepository shipRepository;

    public GR100_ShipCargo(PopulatedsController populatedsController, ShipController shipController, ShipRepository shipRepository) {
        this.populatedsController = populatedsController;
        this.shipController = shipController;
        this.shipRepository = shipRepository;
    }

    @Override
    public void endRound(Game game) {
        var ships = shipController.findAllByGame(game);
        ships.forEach(ship -> {
            var loadUnloadAmount = ship.getLoadUnloadAmount();
            if (loadUnloadAmount == 0) return;

            var city = ship.getCity();
            var cityPopulation = populatedsController.getPopulation(city.getId());
            var shipPopulation = populatedsController.getPopulation(ship.getId());

            loadUnloadAmount = Math.min(loadUnloadAmount, cityPopulation);
            var unfit = populatedsController.increasePopulation(ship.getId(), loadUnloadAmount);
            ship.clearLoadUnloadAmount();
            shipRepository.save(ship);

            var delta = -(loadUnloadAmount - unfit);
            populatedsController.increasePopulation(city.getId(), delta);
        });

    }
}
