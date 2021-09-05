package com.drpicox.game.populateds;

import com.drpicox.game.games.Game;
import com.drpicox.game.players.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface PopulatedsRepository extends JpaRepository<Populated, String> {
    List<Populated> findAllByGame(Game game);
}
