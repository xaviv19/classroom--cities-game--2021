package com.drpicox.game.ships;

import com.drpicox.game.games.Game;
import com.drpicox.game.nameds.NamedsController;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ShipController  {

    private final ShipRepository shipRepository;
    private final NamedsController namedsController;

    public ShipController(ShipRepository shipRepository, NamedsController namedsController) {
        this.shipRepository = shipRepository;
        this.namedsController = namedsController;
    }

    public List<Ship> findAllByGame(Game game) {
        return shipRepository.findAllByGame(game);
    }

    public Optional<Ship> findById(String shipId) {
        return shipRepository.findById(shipId);
    }

    public void changeLoadUnloadAmount(String shipId, int newLoadUnloadAmount) {
        findById(shipId).ifPresent(ship -> {
            ship.changeLoadUnloadAmount(newLoadUnloadAmount);
            shipRepository.save(ship);
        });
    }
}
