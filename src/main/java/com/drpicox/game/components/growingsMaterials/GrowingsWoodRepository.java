package com.drpicox.game.components.growingsMaterials;

import com.drpicox.game.games.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface GrowingsWoodRepository extends JpaRepository<GrowingWood, String> {
    List<GrowingWood> findAllByGame(Game game);
}
