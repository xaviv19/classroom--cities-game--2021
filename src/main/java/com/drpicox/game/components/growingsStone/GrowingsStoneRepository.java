package com.drpicox.game.components.growingsStone;

import com.drpicox.game.games.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface GrowingsStoneRepository extends JpaRepository<GrowingStone, String> {
    List<GrowingStone> findAllByGame(Game game);
}

