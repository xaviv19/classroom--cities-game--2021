package com.drpicox.game.components.growingsIron;

import com.drpicox.game.games.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface GrowingsIronRepository extends JpaRepository<GrowingIron, String> {
    List<GrowingIron> findAllByGame(Game game);
}
