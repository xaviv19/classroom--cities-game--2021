package com.drpicox.game.named;

import com.drpicox.game.cities.City;
import com.drpicox.game.games.Game;
import com.drpicox.game.players.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface NamedRepository extends JpaRepository<Named, String> {
    List<Named> findAllByGame(Game game);
}
