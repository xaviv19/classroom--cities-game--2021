package com.drpicox.game.ships;

import com.drpicox.game.cities.CityController;
import com.drpicox.game.games.Game;
import com.drpicox.game.games.GameRounder;
import org.springframework.stereotype.Component;

@Component
public class GR100_ShipCargo implements GameRounder {

    private final CityController cityController;
    private final ShipController shipController;
    private final ShipRepository shipRepository;

    public GR100_ShipCargo(CityController cityController, ShipController shipController, ShipRepository shipRepository) {
        this.cityController = cityController;
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
            var cityPopulation = city.getPopulation();
            var shipPopulation = ship.getPopulation();

            loadUnloadAmount = Math.min(loadUnloadAmount, cityPopulation);
            var unfit = ship.increasePopulation(loadUnloadAmount);
            ship.clearLoadUnloadAmount();
            shipRepository.save(ship);

            cityController.increasePopulation(city, -(loadUnloadAmount - unfit));
        });

    }
}
