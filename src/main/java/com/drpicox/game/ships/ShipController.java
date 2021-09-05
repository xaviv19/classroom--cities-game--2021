package com.drpicox.game.ships;

import com.drpicox.game.games.Game;
import com.drpicox.game.named.NamedController;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ShipController  {

    private final ShipRepository shipRepository;
    private final NamedController namedController;

    public ShipController(ShipRepository shipRepository, NamedController namedController) {
        this.shipRepository = shipRepository;
        this.namedController = namedController;
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
