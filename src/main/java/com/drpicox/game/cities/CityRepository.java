package com.drpicox.game.cities;

import com.drpicox.game.games.Game;
import com.drpicox.game.players.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface CityRepository extends JpaRepository<City, Long> {
    List<City> findAllByGame(Game game);
    List<City> findAllByGameAndOwner(Game game, Player owner);
}
