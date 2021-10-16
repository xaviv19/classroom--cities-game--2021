package com.drpicox.game.components.withBuildings;

import com.drpicox.game.games.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface WithBuildingsRepository extends JpaRepository<WithBuildings, String> {
    List<WithBuildings> findAllByGame(Game game);

    List<WithBuildings> findAllByGameAndOrderBuildNotNull(Game game);
}
