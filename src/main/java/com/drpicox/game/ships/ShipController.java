package com.drpicox.game.ships;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.GameJoiner;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ShipController  {

    private final ShipRepository shipRepository;

    public ShipController(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    public List<Ship> findAllByGame(Game game) {
        return shipRepository.findAllByGame(game);
    }

    public Optional<Ship> findById(Long shipId) {
        return shipRepository.findById(shipId);
    }

    public void changeShipName(Long shipId, String newShipName) {
        findById(shipId).ifPresent(ship -> {
            ship.changeShipName(newShipName);
            shipRepository.save(ship);
        });
    }

    public void changeLoadUnloadAmount(Long shipId, int newLoadUnloadAmount) {
        findById(shipId).ifPresent(ship -> {
            ship.changeLoadUnloadAmount(newLoadUnloadAmount);
            shipRepository.save(ship);
        });
    }
}
