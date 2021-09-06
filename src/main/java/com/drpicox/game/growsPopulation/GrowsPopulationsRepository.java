package com.drpicox.game.growsPopulation;

import com.drpicox.game.games.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface GrowsPopulationsRepository extends JpaRepository<GrowsPopulation, String> {
    List<GrowsPopulation> findAllByGame(Game game);
}
