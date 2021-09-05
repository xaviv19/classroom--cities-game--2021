package com.drpicox.game.ships;

import com.drpicox.game.games.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface ShipRepository extends JpaRepository<Ship, String> {
    List<Ship> findAllByGame(Game game);
}
